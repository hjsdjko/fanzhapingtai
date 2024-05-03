package com.entity.view;

import com.entity.FanzhashipinCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 预约项目收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fanzhashipin_collection")
public class FanzhashipinCollectionView extends FanzhashipinCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String fanzhashipinCollectionValue;



		//级联表 fanzhashipin
			/**
			* 视频标题
			*/
			private String fanzhashipinName;
			/**
			* 视频类型
			*/
			private Integer fanzhashipinTypes;
				/**
				* 视频类型的值
				*/
				private String fanzhashipinValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FanzhashipinCollectionView() {

	}

	public FanzhashipinCollectionView(FanzhashipinCollectionEntity fanzhashipinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, fanzhashipinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getFanzhashipinCollectionValue() {
				return fanzhashipinCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setFanzhashipinCollectionValue(String fanzhashipinCollectionValue) {
				this.fanzhashipinCollectionValue = fanzhashipinCollectionValue;
			}







				//级联表的get和set fanzhashipin
					/**
					* 获取： 视频标题
					*/
					public String getFanzhashipinName() {
						return fanzhashipinName;
					}
					/**
					* 设置： 视频标题
					*/
					public void setFanzhashipinName(String fanzhashipinName) {
						this.fanzhashipinName = fanzhashipinName;
					}
					/**
					* 获取： 视频类型
					*/
					public Integer getFanzhashipinTypes() {
						return fanzhashipinTypes;
					}
					/**
					* 设置： 视频类型
					*/
					public void setFanzhashipinTypes(Integer fanzhashipinTypes) {
						this.fanzhashipinTypes = fanzhashipinTypes;
					}


						/**
						* 获取： 视频类型的值
						*/
						public String getFanzhashipinValue() {
							return fanzhashipinValue;
						}
						/**
						* 设置： 视频类型的值
						*/
						public void setFanzhashipinValue(String fanzhashipinValue) {
							this.fanzhashipinValue = fanzhashipinValue;
						}
					/**
					* 获取： 项目封面
					*/
					public String getFanzhashipinPhoto() {
						return fanzhashipinPhoto;
					}
					/**
					* 设置： 项目封面
					*/
					public void setFanzhashipinPhoto(String fanzhashipinPhoto) {
						this.fanzhashipinPhoto = fanzhashipinPhoto;
					}
					/**
					* 获取： 赞
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}
					/**
					* 获取： 踩
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}
					/**
					* 获取： 项目详情
					*/
					public String getFanzhashipinContent() {
						return fanzhashipinContent;
					}
					/**
					* 设置： 项目详情
					*/
					public void setFanzhashipinContent(String fanzhashipinContent) {
						this.fanzhashipinContent = fanzhashipinContent;
					}
					/**
					* 获取： 假删
					*/
					public Integer getFanzhashipinDelete() {
						return fanzhashipinDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setFanzhashipinDelete(Integer fanzhashipinDelete) {
						this.fanzhashipinDelete = fanzhashipinDelete;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
