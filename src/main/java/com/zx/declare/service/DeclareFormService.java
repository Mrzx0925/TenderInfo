package com.zx.declare.service;

import com.zx.declare.entity.DeclareForm;
import com.zx.declare.repository.DeclareInfoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/******************************************************
 类名： DeclareFormService
 功能：Service层,对数据处理，返回给Controller层
 作者： 张喜
 版本： 2.0版
 日期： 2019年10月12日
 修改日期：2019年10月14日
 备注：第二版
 *****************************************************/
@Service
public class DeclareFormService {


    @Autowired
    DeclareInfoRespository declareInfoRespository;

    /**
     * 函数名：getDeclareInfo
     * 功能：查询数据库所有的招标信息
     * 返回值：List<DeclareForm> 招标信息数组（json）格式
     */
    public List<DeclareForm> getDeclareInfo() {
        List<DeclareForm> declareFormList = declareInfoRespository.findAll();
        return declareFormList;
    }

    /**
     * 函数名：getDeclareInfoById
     * 功能：根据项目Id查询数据库的招标信息
     * 返回值：declareForm 招标信息
     */
    public DeclareForm getDeclareInfoById(int id) {
        DeclareForm declareForm = declareInfoRespository.getDeclareInfoById(id);
        return declareForm;
    }

    /**
     * 函数名：getDeclareInfoByName
     * 功能：根据项目名称查询数据库的招标信息
     * 返回值：declareForm 招标信息
     */
    public DeclareForm getDeclareInfoByName(String name) {
        DeclareForm declareForm = declareInfoRespository.findByName(name);

        return declareForm;
    }

    /**
     * 函数名：deleteById
     * 功能：根据项目编号(ID) 删除相应的招标信息
     * 返回值：boolean 成功或者失败
     */
    public boolean deleteById(int id) {
        declareInfoRespository.deleteById(id);
        return true;
    }

    /**
     * 函数名：addDeclareInfo
     * 功能：增加招标信息
     * 返回值：boolean 成功或者失败
     */

    public boolean addDeclareInfo(DeclareForm info) {
        java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
        info.setApplydate(currentDate);
        declareInfoRespository.save(info);
        return true;
    }

    /**
     * 函数名：updateDeclareInfo
     * 功能：更新招标信息
     * 返回值：boolean 成功或者失败
     */
    public boolean updateDeclareInfo(int id, DeclareForm info) {
        DeclareForm declareForm = declareInfoRespository.findById(id).get();
        declareForm.setFinishdate(info.getFinishdate());
        declareForm.setProjectno(info.getProjectno());
        declareForm.setProjectcontent(info.getProjectcontent());
        declareForm.setProjectname(info.getProjectname());
        declareForm.setNote(info.getNote());
        declareInfoRespository.save(declareForm);
        return true;
    }

    /**
     * 函数名：getContext
     * 功能：根据ID返回项目内容
     * 返回值：String 项目内容
     */
    public String getContent( int id) {
        return declareInfoRespository.findContext(id);
    }

}
