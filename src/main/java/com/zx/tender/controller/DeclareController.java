package com.zx.tender.controller;

import com.zx.tender.entity.DeclareForm;
import com.zx.tender.service.DeclareFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.util.List;

/******************************************************
 类名： TenderInfoController
 功能： Controller层,返回给前端json数据，供前端使用
 作者： 张喜
 版本： 2.0版
 日期： 2019年10月10日
 修改日期：2019年10月12日
 备注：第二版
 *****************************************************/

@RestController
public class DeclareController {
    @Autowired
    DeclareFormService declareFormService;


    /**
     * 函数名：getDeclareInfo
     * 功能：返回json形式的招标信息数组
     * 返回值：declareFormList 招标信息数组（json）格式
     */
    @PostMapping("/queryall")
    public List<DeclareForm> getDeclareInfo(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        List<DeclareForm> declareFormList = declareFormService.getDeclareInfo();
        return declareFormList;
    }

    /**
     * 函数名：getDeclareInfoByName
     * 功能：返回json格式的招标信息给前端
     * 返回值：declareForm 招标信息
     */
    @PostMapping("/queryby/{name}")
    public DeclareForm getDeclareInfoByName(@PathVariable String name, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        DeclareForm declareForm = declareFormService.getDeclareInfoByName(name);
        return declareForm;
    }

    /**
     * 函数名：deleteById
     * 功能：根据前端的信息删除信息
     * 返回值：boolean 成功或者失败
     */
    @PostMapping("/delete/{id}")
    public boolean deleteById(@PathVariable int id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        declareFormService.deleteById(id);
        return true;
    }

    /**
     * 函数名：addDeclareInfo
     * 功能: 根据前端的信息增加招标信息
     * 返回值：boolean 成功或者失败
     */
    @PostMapping("/addDeclareInfo")
    public boolean add(DeclareForm info, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        declareFormService.addDeclareInfo(info);
        return true;
    }

    /**
     * 函数名：updateDeclareInfo
     * 功能：根据前端上传的信息更新招标信息
     * 返回值：boolean 成功或者失败
     */
    @PostMapping("/update/{id}")
    public boolean updateDeclareInfo(@PathVariable int id, DeclareForm info, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*"); //前后端分离ajax访问需要
        declareFormService.updateDeclareInfo(id, info);
        return true;
    }

    /**
     * 函数名：getContext
     * 功能：返回项目内容给前端展示
     * 返回值：String 项目内容
     */
    @GetMapping("/findcontext/{id}")
    public String getContext(@PathVariable int id) {
        return declareFormService.getContent(id);
    }


}
