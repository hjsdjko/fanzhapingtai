package com.entity.view;

import com.entity.FanzhashipinEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 反诈视频
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fanzhashipin")
public class FanzhashipinView extends FanzhashipinEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 视频类型的值
		*/
		private String fanzhashipinValue;



	public FanzhashipinView() {

	}

	public FanzhashipinView(FanzhashipinEntity fanzhashipinEntity) {
		try {
			BeanUtils.copyProperties(this, fanzhashipinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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










}
