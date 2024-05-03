package com.dao;

import com.entity.FanzhashipinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FanzhashipinLiuyanView;

/**
 * 视频留言 Dao 接口
 *
 * @author 
 */
public interface FanzhashipinLiuyanDao extends BaseMapper<FanzhashipinLiuyanEntity> {

   List<FanzhashipinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
