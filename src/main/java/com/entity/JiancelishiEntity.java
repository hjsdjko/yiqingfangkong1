package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 检测历史
 *
 * @author 
 * @email
 */
@TableName("jiancelishi")
public class JiancelishiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiancelishiEntity() {

	}

	public JiancelishiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 患者
     */
    @TableField(value = "huanzhexinxi_id")

    private Integer huanzhexinxiId;


    /**
     * 检测结果
     */
    @TableField(value = "jiancelishi_types")

    private Integer jiancelishiTypes;


    /**
     * 体温
     */
    @TableField(value = "jiancelishi_number")

    private Double jiancelishiNumber;


    /**
     * 检测地点
     */
    @TableField(value = "jiancelishi_address")

    private String jiancelishiAddress;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "jiancelishi_time")

    private Date jiancelishiTime;


    /**
     * 检查详情
     */
    @TableField(value = "jiancelishi_content")

    private String jiancelishiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：患者
	 */
    public Integer getHuanzhexinxiId() {
        return huanzhexinxiId;
    }
    /**
	 * 获取：患者
	 */

    public void setHuanzhexinxiId(Integer huanzhexinxiId) {
        this.huanzhexinxiId = huanzhexinxiId;
    }
    /**
	 * 设置：检测结果
	 */
    public Integer getJiancelishiTypes() {
        return jiancelishiTypes;
    }
    /**
	 * 获取：检测结果
	 */

    public void setJiancelishiTypes(Integer jiancelishiTypes) {
        this.jiancelishiTypes = jiancelishiTypes;
    }
    /**
	 * 设置：体温
	 */
    public Double getJiancelishiNumber() {
        return jiancelishiNumber;
    }
    /**
	 * 获取：体温
	 */

    public void setJiancelishiNumber(Double jiancelishiNumber) {
        this.jiancelishiNumber = jiancelishiNumber;
    }
    /**
	 * 设置：检测地点
	 */
    public String getJiancelishiAddress() {
        return jiancelishiAddress;
    }
    /**
	 * 获取：检测地点
	 */

    public void setJiancelishiAddress(String jiancelishiAddress) {
        this.jiancelishiAddress = jiancelishiAddress;
    }
    /**
	 * 设置：检测时间
	 */
    public Date getJiancelishiTime() {
        return jiancelishiTime;
    }
    /**
	 * 获取：检测时间
	 */

    public void setJiancelishiTime(Date jiancelishiTime) {
        this.jiancelishiTime = jiancelishiTime;
    }
    /**
	 * 设置：检查详情
	 */
    public String getJiancelishiContent() {
        return jiancelishiContent;
    }
    /**
	 * 获取：检查详情
	 */

    public void setJiancelishiContent(String jiancelishiContent) {
        this.jiancelishiContent = jiancelishiContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiancelishi{" +
            "id=" + id +
            ", huanzhexinxiId=" + huanzhexinxiId +
            ", jiancelishiTypes=" + jiancelishiTypes +
            ", jiancelishiNumber=" + jiancelishiNumber +
            ", jiancelishiAddress=" + jiancelishiAddress +
            ", jiancelishiTime=" + jiancelishiTime +
            ", jiancelishiContent=" + jiancelishiContent +
            ", createTime=" + createTime +
        "}";
    }
}
