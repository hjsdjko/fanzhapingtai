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
 * 反诈视频
 *
 * @author 
 * @email
 */
@TableName("fanzhashipin")
public class FanzhashipinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FanzhashipinEntity() {

	}

	public FanzhashipinEntity(T t) {
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
     * 视频标题
     */
    @TableField(value = "fanzhashipin_name")

    private String fanzhashipinName;


    /**
     * 视频类型
     */
    @TableField(value = "fanzhashipin_types")

    private Integer fanzhashipinTypes;


    /**
     * 视频封面
     */
    @TableField(value = "fanzhashipin_photo")

    private String fanzhashipinPhoto;


    /**
     * 视频
     */
    @TableField(value = "fanzhashipin_video")

    private String fanzhashipinVideo;


    /**
     * 赞
     */
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 项目详情
     */
    @TableField(value = "fanzhashipin_content")

    private String fanzhashipinContent;


    /**
     * 假删
     */
    @TableField(value = "fanzhashipin_delete")

    private Integer fanzhashipinDelete;


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
	 * 设置：视频标题
	 */
    public String getFanzhashipinName() {
        return fanzhashipinName;
    }


    /**
	 * 获取：视频标题
	 */

    public void setFanzhashipinName(String fanzhashipinName) {
        this.fanzhashipinName = fanzhashipinName;
    }
    /**
	 * 设置：视频类型
	 */
    public Integer getFanzhashipinTypes() {
        return fanzhashipinTypes;
    }


    /**
	 * 获取：视频类型
	 */

    public void setFanzhashipinTypes(Integer fanzhashipinTypes) {
        this.fanzhashipinTypes = fanzhashipinTypes;
    }
    /**
	 * 设置：视频封面
	 */
    public String getFanzhashipinPhoto() {
        return fanzhashipinPhoto;
    }


    /**
	 * 获取：视频封面
	 */

    public void setFanzhashipinPhoto(String fanzhashipinPhoto) {
        this.fanzhashipinPhoto = fanzhashipinPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getFanzhashipinVideo() {
        return fanzhashipinVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setFanzhashipinVideo(String fanzhashipinVideo) {
        this.fanzhashipinVideo = fanzhashipinVideo;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：项目详情
	 */
    public String getFanzhashipinContent() {
        return fanzhashipinContent;
    }


    /**
	 * 获取：项目详情
	 */

    public void setFanzhashipinContent(String fanzhashipinContent) {
        this.fanzhashipinContent = fanzhashipinContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getFanzhashipinDelete() {
        return fanzhashipinDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setFanzhashipinDelete(Integer fanzhashipinDelete) {
        this.fanzhashipinDelete = fanzhashipinDelete;
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
        return "Fanzhashipin{" +
            "id=" + id +
            ", fanzhashipinName=" + fanzhashipinName +
            ", fanzhashipinTypes=" + fanzhashipinTypes +
            ", fanzhashipinPhoto=" + fanzhashipinPhoto +
            ", fanzhashipinVideo=" + fanzhashipinVideo +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", fanzhashipinContent=" + fanzhashipinContent +
            ", fanzhashipinDelete=" + fanzhashipinDelete +
            ", createTime=" + createTime +
        "}";
    }
}
