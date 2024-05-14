package com.entity.view;

import com.entity.HuanzhexinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 患者信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huanzhexinxi")
public class HuanzhexinxiView extends HuanzhexinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 患者类型的值
		*/
		private String huanzhexinxiValue;



	public HuanzhexinxiView() {

	}

	public HuanzhexinxiView(HuanzhexinxiEntity huanzhexinxiEntity) {
		try {
			BeanUtils.copyProperties(this, huanzhexinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 患者类型的值
			*/
			public String getHuanzhexinxiValue() {
				return huanzhexinxiValue;
			}
			/**
			* 设置： 患者类型的值
			*/
			public void setHuanzhexinxiValue(String huanzhexinxiValue) {
				this.huanzhexinxiValue = huanzhexinxiValue;
			}









}
