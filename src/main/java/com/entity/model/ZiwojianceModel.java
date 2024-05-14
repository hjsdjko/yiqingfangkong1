package com.entity.model;

import com.entity.ZiwojianceEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 自我检测
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZiwojianceModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 检测结果
     */
    private Integer jiancelishiTypes;


    /**
     * 体温
     */
    private Double ziwojianceNumber;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date ziwojianceTime;


    /**
     * 检查详情
     */
    private String ziwojianceContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：检测结果
	 */
    public Integer getJiancelishiTypes() {
        return jiancelishiTypes;
    }


    /**
	 * 设置：检测结果
	 */
    public void setJiancelishiTypes(Integer jiancelishiTypes) {
        this.jiancelishiTypes = jiancelishiTypes;
    }
    /**
	 * 获取：体温
	 */
    public Double getZiwojianceNumber() {
        return ziwojianceNumber;
    }


    /**
	 * 设置：体温
	 */
    public void setZiwojianceNumber(Double ziwojianceNumber) {
        this.ziwojianceNumber = ziwojianceNumber;
    }
    /**
	 * 获取：检测时间
	 */
    public Date getZiwojianceTime() {
        return ziwojianceTime;
    }


    /**
	 * 设置：检测时间
	 */
    public void setZiwojianceTime(Date ziwojianceTime) {
        this.ziwojianceTime = ziwojianceTime;
    }
    /**
	 * 获取：检查详情
	 */
    public String getZiwojianceContent() {
        return ziwojianceContent;
    }


    /**
	 * 设置：检查详情
	 */
    public void setZiwojianceContent(String ziwojianceContent) {
        this.ziwojianceContent = ziwojianceContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
