package com.entity.vo;

import com.entity.JiancelishiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 检测历史
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiancelishi")
public class JiancelishiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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

}
