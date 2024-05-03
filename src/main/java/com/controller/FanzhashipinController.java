
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 反诈视频
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fanzhashipin")
public class FanzhashipinController {
    private static final Logger logger = LoggerFactory.getLogger(FanzhashipinController.class);

    @Autowired
    private FanzhashipinService fanzhashipinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("fanzhashipinDeleteStart",1);params.put("fanzhashipinDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fanzhashipinService.queryPage(params);

        //字典表数据转换
        List<FanzhashipinView> list =(List<FanzhashipinView>)page.getList();
        for(FanzhashipinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FanzhashipinEntity fanzhashipin = fanzhashipinService.selectById(id);
        if(fanzhashipin !=null){
            //entity转view
            FanzhashipinView view = new FanzhashipinView();
            BeanUtils.copyProperties( fanzhashipin , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FanzhashipinEntity fanzhashipin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fanzhashipin:{}",this.getClass().getName(),fanzhashipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<FanzhashipinEntity> queryWrapper = new EntityWrapper<FanzhashipinEntity>()
            .eq("fanzhashipin_name", fanzhashipin.getFanzhashipinName())
            .eq("fanzhashipin_types", fanzhashipin.getFanzhashipinTypes())
            .eq("fanzhashipin_video", fanzhashipin.getFanzhashipinVideo())
            .eq("zan_number", fanzhashipin.getZanNumber())
            .eq("cai_number", fanzhashipin.getCaiNumber())
            .eq("fanzhashipin_delete", fanzhashipin.getFanzhashipinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanzhashipinEntity fanzhashipinEntity = fanzhashipinService.selectOne(queryWrapper);
        if(fanzhashipinEntity==null){
            fanzhashipin.setFanzhashipinDelete(1);
            fanzhashipin.setCreateTime(new Date());
            fanzhashipinService.insert(fanzhashipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FanzhashipinEntity fanzhashipin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fanzhashipin:{}",this.getClass().getName(),fanzhashipin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<FanzhashipinEntity> queryWrapper = new EntityWrapper<FanzhashipinEntity>()
            .notIn("id",fanzhashipin.getId())
            .andNew()
            .eq("fanzhashipin_name", fanzhashipin.getFanzhashipinName())
            .eq("fanzhashipin_types", fanzhashipin.getFanzhashipinTypes())
            .eq("fanzhashipin_video", fanzhashipin.getFanzhashipinVideo())
            .eq("zan_number", fanzhashipin.getZanNumber())
            .eq("cai_number", fanzhashipin.getCaiNumber())
            .eq("fanzhashipin_delete", fanzhashipin.getFanzhashipinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanzhashipinEntity fanzhashipinEntity = fanzhashipinService.selectOne(queryWrapper);
        if("".equals(fanzhashipin.getFanzhashipinPhoto()) || "null".equals(fanzhashipin.getFanzhashipinPhoto())){
                fanzhashipin.setFanzhashipinPhoto(null);
        }
        if("".equals(fanzhashipin.getFanzhashipinVideo()) || "null".equals(fanzhashipin.getFanzhashipinVideo())){
                fanzhashipin.setFanzhashipinVideo(null);
        }
        if(fanzhashipinEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      fanzhashipin.set
            //  }
            fanzhashipinService.updateById(fanzhashipin);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<FanzhashipinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            FanzhashipinEntity fanzhashipinEntity = new FanzhashipinEntity();
            fanzhashipinEntity.setId(id);
            fanzhashipinEntity.setFanzhashipinDelete(2);
            list.add(fanzhashipinEntity);
        }
        if(list != null && list.size() >0){
            fanzhashipinService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<FanzhashipinEntity> fanzhashipinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FanzhashipinEntity fanzhashipinEntity = new FanzhashipinEntity();
//                            fanzhashipinEntity.setFanzhashipinName(data.get(0));                    //视频标题 要改的
//                            fanzhashipinEntity.setFanzhashipinTypes(Integer.valueOf(data.get(0)));   //视频类型 要改的
//                            fanzhashipinEntity.setFanzhashipinPhoto("");//照片
//                            fanzhashipinEntity.setFanzhashipinVideo(data.get(0));                    //视频 要改的
//                            fanzhashipinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            fanzhashipinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            fanzhashipinEntity.setFanzhashipinContent("");//照片
//                            fanzhashipinEntity.setFanzhashipinDelete(1);//逻辑删除字段
//                            fanzhashipinEntity.setCreateTime(date);//时间
                            fanzhashipinList.add(fanzhashipinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fanzhashipinService.insertBatch(fanzhashipinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fanzhashipinService.queryPage(params);

        //字典表数据转换
        List<FanzhashipinView> list =(List<FanzhashipinView>)page.getList();
        for(FanzhashipinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FanzhashipinEntity fanzhashipin = fanzhashipinService.selectById(id);
            if(fanzhashipin !=null){


                //entity转view
                FanzhashipinView view = new FanzhashipinView();
                BeanUtils.copyProperties( fanzhashipin , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FanzhashipinEntity fanzhashipin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fanzhashipin:{}",this.getClass().getName(),fanzhashipin.toString());
        Wrapper<FanzhashipinEntity> queryWrapper = new EntityWrapper<FanzhashipinEntity>()
            .eq("fanzhashipin_name", fanzhashipin.getFanzhashipinName())
            .eq("fanzhashipin_types", fanzhashipin.getFanzhashipinTypes())
            .eq("fanzhashipin_video", fanzhashipin.getFanzhashipinVideo())
            .eq("zan_number", fanzhashipin.getZanNumber())
            .eq("cai_number", fanzhashipin.getCaiNumber())
            .eq("fanzhashipin_delete", fanzhashipin.getFanzhashipinDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FanzhashipinEntity fanzhashipinEntity = fanzhashipinService.selectOne(queryWrapper);
        if(fanzhashipinEntity==null){
            fanzhashipin.setFanzhashipinDelete(1);
            fanzhashipin.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      fanzhashipin.set
        //  }
        fanzhashipinService.insert(fanzhashipin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
