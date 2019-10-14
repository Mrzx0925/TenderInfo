package com.zx.declare.repository;

import com.zx.declare.entity.DeclareForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/******************************************************
 接口名： DeclareInfoRespository
 功能：继承JpaRepository，自写一些查询方法
 作者： 张喜
 版本： 3.0版
 日期： 2019年10月10日
 修改日期：2019年10月14日
 备注：第三版
 *****************************************************/

//继承JpaRepository
public interface DeclareInfoRespository extends JpaRepository<DeclareForm, Integer> {
    //根据项目名称查询信息
    @Query(value = "select *from declareform where Projectname = ?1",nativeQuery = true)
    DeclareForm findByName(String name);
    //根据项目Id查询信息
    @Query(value = "select *from declareform where ID = ?1",nativeQuery = true)
    DeclareForm getDeclareInfoById(int id);
    //根据项目编号查询内容
    @Query(value = "select projectcontent from declareform where id = ?1",nativeQuery = true)
    String findContext(int projectno);


}
