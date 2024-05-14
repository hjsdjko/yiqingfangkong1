
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 检测历史
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiancelishi")
public class JiancelishiController {
    private static final Logger logger = LoggerFactory.getLogger(JiancelishiController.class);

    @Autowired
    private JiancelishiService jiancelishiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private HuanzhexinxiService huanzhexinxiService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiancelishiService.queryPage(params);

        //字典表数据转换
        List<JiancelishiView> list =(List<JiancelishiView>)page.getList();
        for(JiancelishiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiancelishiEntity jiancelishi = jiancelishiService.selectById(id);
        if(jiancelishi !=null){
            //entity转view
            JiancelishiView view = new JiancelishiView();
            BeanUtils.copyProperties( jiancelishi , view );//把实体数据重构到view中

                //级联表
                HuanzhexinxiEntity huanzhexinxi = huanzhexinxiService.selectById(jiancelishi.getHuanzhexinxiId());
                if(huanzhexinxi != null){
                    BeanUtils.copyProperties( huanzhexinxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setHuanzhexinxiId(huanzhexinxi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiancelishiEntity jiancelishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiancelishi:{}",this.getClass().getName(),jiancelishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiancelishiEntity> queryWrapper = new EntityWrapper<JiancelishiEntity>()
            .eq("huanzhexinxi_id", jiancelishi.getHuanzhexinxiId())
            .eq("jiancelishi_types", jiancelishi.getJiancelishiTypes())
            .eq("jiancelishi_address", jiancelishi.getJiancelishiAddress())
            .eq("jiancelishi_time", new SimpleDateFormat("yyyy-MM-dd").format(jiancelishi.getJiancelishiTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiancelishiEntity jiancelishiEntity = jiancelishiService.selectOne(queryWrapper);
        if(jiancelishiEntity==null){
            jiancelishi.setCreateTime(new Date());
            jiancelishiService.insert(jiancelishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiancelishiEntity jiancelishi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiancelishi:{}",this.getClass().getName(),jiancelishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiancelishiEntity> queryWrapper = new EntityWrapper<JiancelishiEntity>()
            .notIn("id",jiancelishi.getId())
            .andNew()
            .eq("huanzhexinxi_id", jiancelishi.getHuanzhexinxiId())
            .eq("jiancelishi_types", jiancelishi.getJiancelishiTypes())
            .eq("jiancelishi_address", jiancelishi.getJiancelishiAddress())
            .eq("jiancelishi_time", new SimpleDateFormat("yyyy-MM-dd").format(jiancelishi.getJiancelishiTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiancelishiEntity jiancelishiEntity = jiancelishiService.selectOne(queryWrapper);
        if(jiancelishiEntity==null){
            jiancelishiService.updateById(jiancelishi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiancelishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiancelishiEntity> jiancelishiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiancelishiEntity jiancelishiEntity = new JiancelishiEntity();
//                            jiancelishiEntity.setHuanzhexinxiId(Integer.valueOf(data.get(0)));   //患者 要改的
//                            jiancelishiEntity.setJiancelishiTypes(Integer.valueOf(data.get(0)));   //检测结果 要改的
//                            jiancelishiEntity.setJiancelishiNumber(data.get(0));                    //体温 要改的
//                            jiancelishiEntity.setJiancelishiAddress(data.get(0));                    //检测地点 要改的
//                            jiancelishiEntity.setJiancelishiTime(sdf.parse(data.get(0)));          //检测时间 要改的
//                            jiancelishiEntity.setJiancelishiContent("");//详情和图片
//                            jiancelishiEntity.setCreateTime(date);//时间
                            jiancelishiList.add(jiancelishiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiancelishiService.insertBatch(jiancelishiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
