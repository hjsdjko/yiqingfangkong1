
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
 * 患者信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huanzhexinxi")
public class HuanzhexinxiController {
    private static final Logger logger = LoggerFactory.getLogger(HuanzhexinxiController.class);

    @Autowired
    private HuanzhexinxiService huanzhexinxiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

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
        PageUtils page = huanzhexinxiService.queryPage(params);

        //字典表数据转换
        List<HuanzhexinxiView> list =(List<HuanzhexinxiView>)page.getList();
        for(HuanzhexinxiView c:list){
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
        HuanzhexinxiEntity huanzhexinxi = huanzhexinxiService.selectById(id);
        if(huanzhexinxi !=null){
            //entity转view
            HuanzhexinxiView view = new HuanzhexinxiView();
            BeanUtils.copyProperties( huanzhexinxi , view );//把实体数据重构到view中

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
    public R save(@RequestBody HuanzhexinxiEntity huanzhexinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huanzhexinxi:{}",this.getClass().getName(),huanzhexinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuanzhexinxiEntity> queryWrapper = new EntityWrapper<HuanzhexinxiEntity>()
            .eq("huanzhexinxi_uuid_number", huanzhexinxi.getHuanzhexinxiUuidNumber())
            .eq("huanzhexinxi_name", huanzhexinxi.getHuanzhexinxiName())
            .eq("huanzhexinxi_number", huanzhexinxi.getHuanzhexinxiNumber())
            .eq("huanzhexinxi_types", huanzhexinxi.getHuanzhexinxiTypes())
            .eq("huanzhexinxi_address", huanzhexinxi.getHuanzhexinxiAddress())
            .eq("huanzhexinxi_text", huanzhexinxi.getHuanzhexinxiText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuanzhexinxiEntity huanzhexinxiEntity = huanzhexinxiService.selectOne(queryWrapper);
        if(huanzhexinxiEntity==null){
            huanzhexinxi.setCreateTime(new Date());
            huanzhexinxiService.insert(huanzhexinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuanzhexinxiEntity huanzhexinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huanzhexinxi:{}",this.getClass().getName(),huanzhexinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<HuanzhexinxiEntity> queryWrapper = new EntityWrapper<HuanzhexinxiEntity>()
            .notIn("id",huanzhexinxi.getId())
            .andNew()
            .eq("huanzhexinxi_uuid_number", huanzhexinxi.getHuanzhexinxiUuidNumber())
            .eq("huanzhexinxi_name", huanzhexinxi.getHuanzhexinxiName())
            .eq("huanzhexinxi_number", huanzhexinxi.getHuanzhexinxiNumber())
            .eq("huanzhexinxi_types", huanzhexinxi.getHuanzhexinxiTypes())
            .eq("huanzhexinxi_address", huanzhexinxi.getHuanzhexinxiAddress())
            .eq("huanzhexinxi_text", huanzhexinxi.getHuanzhexinxiText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuanzhexinxiEntity huanzhexinxiEntity = huanzhexinxiService.selectOne(queryWrapper);
        if(huanzhexinxiEntity==null){
            huanzhexinxiService.updateById(huanzhexinxi);//根据id更新
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
        huanzhexinxiService.deleteBatchIds(Arrays.asList(ids));
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
            List<HuanzhexinxiEntity> huanzhexinxiList = new ArrayList<>();//上传的东西
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
                            HuanzhexinxiEntity huanzhexinxiEntity = new HuanzhexinxiEntity();
//                            huanzhexinxiEntity.setHuanzhexinxiUuidNumber(data.get(0));                    //编号 要改的
//                            huanzhexinxiEntity.setHuanzhexinxiName(data.get(0));                    //患者名称 要改的
//                            huanzhexinxiEntity.setHuanzhexinxiNumber(Integer.valueOf(data.get(0)));   //患者年龄 要改的
//                            huanzhexinxiEntity.setHuanzhexinxiTypes(Integer.valueOf(data.get(0)));   //患者类型 要改的
//                            huanzhexinxiEntity.setHuanzhexinxiAddress(data.get(0));                    //现住址 要改的
//                            huanzhexinxiEntity.setHuanzhexinxiText(data.get(0));                    //行动轨迹 要改的
//                            huanzhexinxiEntity.setCreateTime(date);//时间
                            huanzhexinxiList.add(huanzhexinxiEntity);


                            //把要查询是否重复的字段放入map中
                                //编号
                                if(seachFields.containsKey("huanzhexinxiUuidNumber")){
                                    List<String> huanzhexinxiUuidNumber = seachFields.get("huanzhexinxiUuidNumber");
                                    huanzhexinxiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huanzhexinxiUuidNumber = new ArrayList<>();
                                    huanzhexinxiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huanzhexinxiUuidNumber",huanzhexinxiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //编号
                        List<HuanzhexinxiEntity> huanzhexinxiEntities_huanzhexinxiUuidNumber = huanzhexinxiService.selectList(new EntityWrapper<HuanzhexinxiEntity>().in("huanzhexinxi_uuid_number", seachFields.get("huanzhexinxiUuidNumber")));
                        if(huanzhexinxiEntities_huanzhexinxiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuanzhexinxiEntity s:huanzhexinxiEntities_huanzhexinxiUuidNumber){
                                repeatFields.add(s.getHuanzhexinxiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huanzhexinxiService.insertBatch(huanzhexinxiList);
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
