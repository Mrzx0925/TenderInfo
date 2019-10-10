package com.zx.tender.entity;

import javax.persistence.*;
import java.util.Date;

/******************************************************
 类名： TenderInfo
 功能：申报表实体类，使用JPA对应数据库表
 作者： 张喜
 版本： 1.0版
 日期： 2019年10月10日
 修改日期：2019年10月10日
 备注：第一版
 *****************************************************/


//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "tender_info") //@Table来指定和哪个数据表对应;如果省略默认表名就是user；
public class TenderInfo {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;    //项目编号
    @Column(name = "upTime") //对应列
    private String upTime;  //上传时间
    @Column //省略默认是属性名
    private String name; //项目名称
    @Column
    private String context; //项目内容
    @Column(name = "overTime") //对应列
    private String  overTime;  //完成时间
    @Column
    private String note; //备注



    /**
     *函数名：getID
     *功能：获取项目编号
     */
    public Integer getID() {
        return id;
    }
    /**
     *函数名：setID
     *功能：设置项目编号
     */
    public void setID(Integer id) {
        this.id = id;
    }
    /**
     *函数名：getUpTime
     *功能：获取上传时间
     */
    public String getUpTime() {
        return upTime;
    }
    /**
     *函数名：setUpTime
     *功能：设置上传时间
     */
    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }
    /**
     *函数名：getName
     *功能：获取项目名称
     */
    public String getName() {
        return name;
    }
    /**
     *函数名：setName
     *功能：设置项目名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *函数名：getContext
     *功能：获取项目内容
     */
    public String getContext() {
        return context;
    }
    /**
     *函数名：setContext
     *功能：设置项目内容
     */
    public void setContext(String context) {
        this.context = context;
    }
    /**
     *函数名：getOverTime
     *功能：获取完成时间
     */
    public String getOverTime() {
        return overTime;
    }
    /**
     *函数名：setOverTime
     *功能：设置完成时间
     */
    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }
    /**
     *函数名：getNote
     *功能：获取备注
     */
    public String getNote() {
        return note;
    }
    /**
     *函数名：setNote
     *功能：设置备注
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     *函数名：toString
     *功能：返回对象字符串输出
     */
    @Override
    public String toString() {
        return "TenderInfo{" +
                "id=" + id +
                ", upTime=" + upTime +
                ", name='" + name + '\'' +
                ", context='" + context + '\'' +
                ", overTime=" + overTime +
                ", note='" + note + '\'' +
                '}';
    }
}
