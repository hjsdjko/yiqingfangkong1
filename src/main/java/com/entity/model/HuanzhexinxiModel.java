package com.entity.model;

import com.entity.HuanzhexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 患者信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuanzhexinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String huanzhexinxiUuidNumber;


    /**
     * 患者名称
     */
    private String huanzhexinxiName;


    /**
     * 患者年龄
     */
    private Integer huanzhexinxiNumber;


    /**
     * 患者类型
     */
    private Integer huanzhexinxiTypes;


    /**
     * 现住址
     */
    private String huanzhexinxiAddress;


    /**
     * 行动轨迹
     */
    private String huanzhexinxiText;


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
	 * 获取：编号
	 */
    public String getHuanzhexinxiUuidNumber() {
        return huanzhexinxiUuidNumber;
    }


    /**
	 * 设置：编号
	 */
    public void setHuanzhexinxiUuidNumber(String huanzhexinxiUuidNumber) {
        this.huanzhexinxiUuidNumber = huanzhexinxiUuidNumber;
    }
    /**
	 * 获取：患者名称
	 */
    public String getHuanzhexinxiName() {
        return huanzhexinxiName;
    }


    /**
	 * 设置：患者名称
	 */
    public void setHuanzhexinxiName(String huanzhexinxiName) {
        this.huanzhexinxiName = huanzhexinxiName;
    }
    /**
	 * 获取：患者年龄
	 */
    public Integer getHuanzhexinxiNumber() {
        return huanzhexinxiNumber;
    }


    /**
	 * 设置：患者年龄
	 */
    public void setHuanzhexinxiNumber(Integer huanzhexinxiNumber) {
        this.huanzhexinxiNumber = huanzhexinxiNumber;
    }
    /**
	 * 获取：患者类型
	 */
    public Integer getHuanzhexinxiTypes() {
        return huanzhexinxiTypes;
    }


    /**
	 * 设置：患者类型
	 */
    public void setHuanzhexinxiTypes(Integer huanzhexinxiTypes) {
        this.huanzhexinxiTypes = huanzhexinxiTypes;
    }
    /**
	 * 获取：现住址
	 */
    public String getHuanzhexinxiAddress() {
        return huanzhexinxiAddress;
    }


    /**
	 * 设置：现住址
	 */
    public void setHuanzhexinxiAddress(String huanzhexinxiAddress) {
        this.huanzhexinxiAddress = huanzhexinxiAddress;
    }
    /**
	 * 获取：行动轨迹
	 */
    public String getHuanzhexinxiText() {
        return huanzhexinxiText;
    }


    /**
	 * 设置：行动轨迹
	 */
    public void setHuanzhexinxiText(String huanzhexinxiText) {
        this.huanzhexinxiText = huanzhexinxiText;
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
