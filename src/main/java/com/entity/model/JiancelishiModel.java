package com.entity.model;

import com.entity.JiancelishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 检测历史
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiancelishiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 患者
     */
    private Integer huanzhexinxiId;


    /**
     * 检测结果
     */
    private Integer jiancelishiTypes;


    /**
     * 体温
     */
    private Double jiancelishiNumber;


    /**
     * 检测地点
     */
    private String jiancelishiAddress;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiancelishiTime;


    /**
     * 检查详情
     */
    private String jiancelishiContent;


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
	 * 获取：患者
	 */
    public Integer getHuanzhexinxiId() {
        return huanzhexinxiId;
    }


    /**
	 * 设置：患者
	 */
    public void setHuanzhexinxiId(Integer huanzhexinxiId) {
        this.huanzhexinxiId = huanzhexinxiId;
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
    public Double getJiancelishiNumber() {
        return jiancelishiNumber;
    }


    /**
	 * 设置：体温
	 */
    public void setJiancelishiNumber(Double jiancelishiNumber) {
        this.jiancelishiNumber = jiancelishiNumber;
    }
    /**
	 * 获取：检测地点
	 */
    public String getJiancelishiAddress() {
        return jiancelishiAddress;
    }


    /**
	 * 设置：检测地点
	 */
    public void setJiancelishiAddress(String jiancelishiAddress) {
        this.jiancelishiAddress = jiancelishiAddress;
    }
    /**
	 * 获取：检测时间
	 */
    public Date getJiancelishiTime() {
        return jiancelishiTime;
    }


    /**
	 * 设置：检测时间
	 */
    public void setJiancelishiTime(Date jiancelishiTime) {
        this.jiancelishiTime = jiancelishiTime;
    }
    /**
	 * 获取：检查详情
	 */
    public String getJiancelishiContent() {
        return jiancelishiContent;
    }


    /**
	 * 设置：检查详情
	 */
    public void setJiancelishiContent(String jiancelishiContent) {
        this.jiancelishiContent = jiancelishiContent;
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
