package com.entity.vo;

import com.entity.ZiwojianceEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 自我检测
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("ziwojiance")
public class ZiwojianceVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 检测结果
     */

    @TableField(value = "jiancelishi_types")
    private Integer jiancelishiTypes;


    /**
     * 体温
     */

    @TableField(value = "ziwojiance_number")
    private Double ziwojianceNumber;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "ziwojiance_time")
    private Date ziwojianceTime;


    /**
     * 检查详情
     */

    @TableField(value = "ziwojiance_content")
    private String ziwojianceContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
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
    public Double getZiwojianceNumber() {
        return ziwojianceNumber;
    }


    /**
	 * 获取：体温
	 */

    public void setZiwojianceNumber(Double ziwojianceNumber) {
        this.ziwojianceNumber = ziwojianceNumber;
    }
    /**
	 * 设置：检测时间
	 */
    public Date getZiwojianceTime() {
        return ziwojianceTime;
    }


    /**
	 * 获取：检测时间
	 */

    public void setZiwojianceTime(Date ziwojianceTime) {
        this.ziwojianceTime = ziwojianceTime;
    }
    /**
	 * 设置：检查详情
	 */
    public String getZiwojianceContent() {
        return ziwojianceContent;
    }


    /**
	 * 获取：检查详情
	 */

    public void setZiwojianceContent(String ziwojianceContent) {
        this.ziwojianceContent = ziwojianceContent;
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

}
