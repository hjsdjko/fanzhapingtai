package com.entity.model;

import com.entity.FanzhashipinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 反诈视频
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FanzhashipinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 视频标题
     */
    private String fanzhashipinName;


    /**
     * 视频类型
     */
    private Integer fanzhashipinTypes;


    /**
     * 项目封面
     */
    private String fanzhashipinPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 项目详情
     */
    private String fanzhashipinContent;


    /**
     * 假删
     */
    private Integer fanzhashipinDelete;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：视频标题
	 */
    public String getFanzhashipinName() {
        return fanzhashipinName;
    }


    /**
	 * 设置：视频标题
	 */
    public void setFanzhashipinName(String fanzhashipinName) {
        this.fanzhashipinName = fanzhashipinName;
    }
    /**
	 * 获取：视频类型
	 */
    public Integer getFanzhashipinTypes() {
        return fanzhashipinTypes;
    }


    /**
	 * 设置：视频类型
	 */
    public void setFanzhashipinTypes(Integer fanzhashipinTypes) {
        this.fanzhashipinTypes = fanzhashipinTypes;
    }
    /**
	 * 获取：项目封面
	 */
    public String getFanzhashipinPhoto() {
        return fanzhashipinPhoto;
    }


    /**
	 * 设置：项目封面
	 */
    public void setFanzhashipinPhoto(String fanzhashipinPhoto) {
        this.fanzhashipinPhoto = fanzhashipinPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：项目详情
	 */
    public String getFanzhashipinContent() {
        return fanzhashipinContent;
    }


    /**
	 * 设置：项目详情
	 */
    public void setFanzhashipinContent(String fanzhashipinContent) {
        this.fanzhashipinContent = fanzhashipinContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getFanzhashipinDelete() {
        return fanzhashipinDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setFanzhashipinDelete(Integer fanzhashipinDelete) {
        this.fanzhashipinDelete = fanzhashipinDelete;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
