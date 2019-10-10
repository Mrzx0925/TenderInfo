package com.zx.tender.repository;

import com.zx.tender.entity.TenderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/******************************************************
 接口名： TenderInfoRespository
 功能：继承JpaRepository，自写一些查询方法
 作者： 张喜
 版本： 1.0版
 日期： 2019年10月10日
 修改日期：2019年10月10日
 备注：第一版
 *****************************************************/

//继承JpaRepository
public interface TenderInfoRespository extends JpaRepository<TenderInfo, Integer> {
    //根据名称查询
    @Query(value = "select *from tender_info where name = ?1",nativeQuery = true)
    TenderInfo findByName(String name);
}
