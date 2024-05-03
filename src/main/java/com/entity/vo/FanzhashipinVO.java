package com.entity.vo;

import com.entity.FanzhashipinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 反诈视频
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fanzhashipin")
public class FanzhashipinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 项目封面
     */

    @TableField(value = "fanzhashipin_photo")
    private String fanzhashipinPhoto;


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
     * 创建时间 show1 show2 photoShow
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
	 * 设置：项目封面
	 */
    public String getFanzhashipinPhoto() {
        return fanzhashipinPhoto;
    }


    /**
	 * 获取：项目封面
	 */

    public void setFanzhashipinPhoto(String fanzhashipinPhoto) {
        this.fanzhashipinPhoto = fanzhashipinPhoto;
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
