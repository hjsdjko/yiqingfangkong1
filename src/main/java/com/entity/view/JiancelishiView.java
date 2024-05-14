package com.entity.view;

import com.entity.JiancelishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 检测历史
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiancelishi")
public class JiancelishiView extends JiancelishiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 检测结果的值
		*/
		private String jiancelishiValue;



		//级联表 huanzhexinxi
			/**
			* 编号
			*/
			private String huanzhexinxiUuidNumber;
			/**
			* 患者名称
			*/
			private String huanzhexinxiName;
			/**
			* 患者类型
			*/
			private Integer huanzhexinxiTypes;
				/**
				* 患者类型的值
				*/
				private String huanzhexinxiValue;

	public JiancelishiView() {

	}

	public JiancelishiView(JiancelishiEntity jiancelishiEntity) {
		try {
			BeanUtils.copyProperties(this, jiancelishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 检测结果的值
			*/
			public String getJiancelishiValue() {
				return jiancelishiValue;
			}
			/**
			* 设置： 检测结果的值
			*/
			public void setJiancelishiValue(String jiancelishiValue) {
				this.jiancelishiValue = jiancelishiValue;
			}






				//级联表的get和set huanzhexinxi

					/**
					* 获取： 编号
					*/
					public String getHuanzhexinxiUuidNumber() {
						return huanzhexinxiUuidNumber;
					}
					/**
					* 设置： 编号
					*/
					public void setHuanzhexinxiUuidNumber(String huanzhexinxiUuidNumber) {
						this.huanzhexinxiUuidNumber = huanzhexinxiUuidNumber;
					}

					/**
					* 获取： 患者名称
					*/
					public String getHuanzhexinxiName() {
						return huanzhexinxiName;
					}
					/**
					* 设置： 患者名称
					*/
					public void setHuanzhexinxiName(String huanzhexinxiName) {
						this.huanzhexinxiName = huanzhexinxiName;
					}

					/**
					* 获取： 患者类型
					*/
					public Integer getHuanzhexinxiTypes() {
						return huanzhexinxiTypes;
					}
					/**
					* 设置： 患者类型
					*/
					public void setHuanzhexinxiTypes(Integer huanzhexinxiTypes) {
						this.huanzhexinxiTypes = huanzhexinxiTypes;
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
