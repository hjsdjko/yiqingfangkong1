package com.entity.vo;

import com.entity.HuanzhexinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 患者信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huanzhexinxi")
public class HuanzhexinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 编号
     */

    @TableField(value = "huanzhexinxi_uuid_number")
    private String huanzhexinxiUuidNumber;


    /**
     * 患者名称
     */

    @TableField(value = "huanzhexinxi_name")
    private String huanzhexinxiName;


    /**
     * 患者年龄
     */

    @TableField(value = "huanzhexinxi_number")
    private Integer huanzhexinxiNumber;


    /**
     * 患者类型
     */

    @TableField(value = "huanzhexinxi_types")
    private Integer huanzhexinxiTypes;


    /**
     * 现住址
     */

    @TableField(value = "huanzhexinxi_address")
    private String huanzhexinxiAddress;


    /**
     * 行动轨迹
     */

    @TableField(value = "huanzhexinxi_text")
    private String huanzhexinxiText;


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
	 * 设置：编号
	 */
    public String getHuanzhexinxiUuidNumber() {
        return huanzhexinxiUuidNumber;
    }


    /**
	 * 获取：编号
	 */

    public void setHuanzhexinxiUuidNumber(String huanzhexinxiUuidNumber) {
        this.huanzhexinxiUuidNumber = huanzhexinxiUuidNumber;
    }
    /**
	 * 设置：患者名称
	 */
    public String getHuanzhexinxiName() {
        return huanzhexinxiName;
    }


    /**
	 * 获取：患者名称
	 */

    public void setHuanzhexinxiName(String huanzhexinxiName) {
        this.huanzhexinxiName = huanzhexinxiName;
    }
    /**
	 * 设置：患者年龄
	 */
    public Integer getHuanzhexinxiNumber() {
        return huanzhexinxiNumber;
    }


    /**
	 * 获取：患者年龄
	 */

    public void setHuanzhexinxiNumber(Integer huanzhexinxiNumber) {
        this.huanzhexinxiNumber = huanzhexinxiNumber;
    }
    /**
	 * 设置：患者类型
	 */
    public Integer getHuanzhexinxiTypes() {
        return huanzhexinxiTypes;
    }


    /**
	 * 获取：患者类型
	 */

    public void setHuanzhexinxiTypes(Integer huanzhexinxiTypes) {
        this.huanzhexinxiTypes = huanzhexinxiTypes;
    }
    /**
	 * 设置：现住址
	 */
    public String getHuanzhexinxiAddress() {
        return huanzhexinxiAddress;
    }


    /**
	 * 获取：现住址
	 */

    public void setHuanzhexinxiAddress(String huanzhexinxiAddress) {
        this.huanzhexinxiAddress = huanzhexinxiAddress;
    }
    /**
	 * 设置：行动轨迹
	 */
    public String getHuanzhexinxiText() {
        return huanzhexinxiText;
    }


    /**
	 * 获取：行动轨迹
	 */

    public void setHuanzhexinxiText(String huanzhexinxiText) {
        this.huanzhexinxiText = huanzhexinxiText;
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
