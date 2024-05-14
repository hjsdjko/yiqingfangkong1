package com.dao;

import com.entity.JiancelishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiancelishiView;

/**
 * 检测历史 Dao 接口
 *
 * @author 
 */
public interface JiancelishiDao extends BaseMapper<JiancelishiEntity> {

   List<JiancelishiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
