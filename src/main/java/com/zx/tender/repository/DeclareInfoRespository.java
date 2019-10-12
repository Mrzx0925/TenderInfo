package com.zx.tender.repository;

import com.zx.tender.entity.DeclareForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/******************************************************
 接口名： DeclareInfoRespository
 功能：继承JpaRepository，自写一些查询方法
 作者： 张喜
 版本： 2.0版
 日期： 2019年10月10日
 修改日期：2019年10月12日
 备注：第二版
 *****************************************************/

//继承JpaRepository
public interface DeclareInfoRespository extends JpaRepository<DeclareForm, Integer> {
    //根据名称查询
    @Query(value = "select *from declareform where Projectname = ?1",nativeQuery = true)
    DeclareForm findByName(String name);
    //根据项目编号查询内容
    @Query(value = "select projectcontent from declareform where id = ?1",nativeQuery = true)
    String findContext(int projectno);
}
