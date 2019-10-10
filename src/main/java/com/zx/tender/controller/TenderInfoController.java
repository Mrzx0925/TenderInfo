package com.zx.tender.controller;


import com.zx.tender.entity.TenderInfo;
import com.zx.tender.repository.TenderInfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/******************************************************
 类名： TenderInfoController
 功能：Controller层,返回给前端json数据，供前端使用
 作者： 张喜
 版本： 1.0版
 日期： 2019年10月10日
 修改日期：2019年10月10日
 备注：第一版
 *****************************************************/

@RestController
public class TenderInfoController {
    @Autowired
    TenderInfoRespository tenderInfoRespository;


    /**
     *函数名：getTenderInfo
     *功能：查询数据库所有的招标信息
     *返回值：List<TenderInfo> 招标信息数组
     */
    @PostMapping("/queryall")
    public List<TenderInfo> getTenderInfo(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
       List<TenderInfo> tenderInfoList =  tenderInfoRespository.findAll();
       return tenderInfoList;
    }
    /**
     *函数名：getTenderInfoByName
     *功能：根据项目名称查询数据库的招标信息
     *返回值：TenderInfo 招标信息
     */
    @PostMapping("/queryby/{name}")
    public TenderInfo getTenderInfoByName(@PathVariable String name,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        TenderInfo tenderInfo =  tenderInfoRespository.findByName(name);
        return  tenderInfo;
    }

    /**
     *函数名：getTenderInfoByID
     *功能：根据ID查询数据库的招标信息
     *返回值：TenderInfo 招标信息
     */
    @PostMapping("/querybyid/{id}")
    public TenderInfo getTenderInfoByID(@PathVariable int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        TenderInfo tenderInfo =  tenderInfoRespository.findById(id).get();
        return  tenderInfo;
    }

    /**
     *函数名：deleteById
     *功能：根据项目编号(ID) 删除相应的招标信息
     *返回值：boolean 成功或者失败
     */
    @PostMapping("/delete/{id}")
    public boolean deleteById(@PathVariable int id,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        tenderInfoRespository.deleteById(id);
        return true;
    }

    /**
     *函数名：add
     *功能：增加招标信息
     *返回值：boolean 成功或者失败
     */
    @PostMapping("/add")
    public boolean add(TenderInfo info, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        Date  date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        info.setUpTime(dateFormat.format(date));
        tenderInfoRespository.save(info);
        return  true;
    }

    /**
     *函数名：update
     *功能：更新招标信息
     *返回值：boolean 成功或者失败
     */
    @PostMapping("/update/{id}")
    public boolean update(@PathVariable int id,TenderInfo info,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        TenderInfo tenderInfo =  tenderInfoRespository.findById(id).get();
        tenderInfo.setOverTime(info.getOverTime());
        tenderInfo.setContext(info.getContext());
        tenderInfo.setName(info.getContext());
        tenderInfo.setNote(info.getNote());
        tenderInfoRespository.save(tenderInfo);
        return true;
    }

    /**
     *函数名：getContext
     *功能：根据ID返回项目内容
     *返回值：String 项目内容
     */
    @GetMapping("/findcontext/{id}")
    public String getContext(@PathVariable int id){
        return tenderInfoRespository.findContext(id);
    }


}
