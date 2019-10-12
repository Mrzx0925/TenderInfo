package com.zx.tender.entity;

import javax.persistence.*;
import java.sql.Date;

/******************************************************
 类名： DeclareForm
 功能：申报表实体类，使用JPA对应数据库表
 作者： 张喜
 版本： 2.0版
 日期： 2019年10月10日
 修改日期：2019年10月12日
 备注：第二版
 *****************************************************/


//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "declareform") //@Table来指定和哪个数据表对应;
public class DeclareForm {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;    //主键
    @Column(name = "applydate") //对应列
    private Date applydate;  //申请日期
    @Column //省略默认是属性名
    private String projectname; //项目名称
    @Column
    private String projectcontent; //项目内容
    @Column
    private Integer projectno;    //项目编号
    @Column(name = "Finishdate") //对应列
    private Date finishdate;  //完成时间

    @Column
    private String note; //备注

    /**
     * 函数名：getId
     * 功能：返回ID
     * 返回值：id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 函数名：setId
     * 功能：设置ID
     * 返回值：无
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 函数名：getApplydate
     * 功能：返回申请日期
     * 返回值：applydate
     */
    public Date getApplydate() {
        return applydate;
    }

    /**
     * 函数名：setApplydate
     * 功能：设置申请日期
     * 返回值：无
     */
    public void setApplydate(Date applydate) {
        this.applydate = applydate;
    }

    /**
     * 函数名：getProjectname
     * 功能：返回项目名称
     * 返回值：Projectname
     */
    public String getProjectname() {
        return projectname;
    }

    /**
     * 函数名：setProjectname
     * 功能：设置项目名称
     * 返回值：无
     */
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    /**
     * 函数名：getProjectcontent
     * 功能：得到项目内容
     * 返回值：Projectcontent
     */
    public String getProjectcontent() {
        return projectcontent;
    }

    /**
     * 函数名：setProjectcontent
     * 功能：设置项目内容
     * 返回值：无
     */
    public void setProjectcontent(String projectcontent) {
        this.projectcontent = projectcontent;
    }

    /**
     * 函数名：getProjectno
     * 功能：得到项目编号
     * 返回值：Projectno
     */
    public Integer getProjectno() {
        return projectno;
    }

    /**
     * 函数名：setProjectno
     * 功能：设置项目编号
     * 返回值：无
     */
    public void setProjectno(Integer projectno) {
        this.projectno = projectno;
    }

    /**
     * 函数名：getFinishdate
     * 功能：得到完成时间
     * 返回值：Finishdate
     */
    public Date getFinishdate() {
        return finishdate;
    }

    /**
     * 函数名：setFinishdate
     * 功能：设置完成时间
     * 返回值：无
     */
    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    /**
     * 函数名：getNote
     * 功能：得到备注
     * 返回值：note
     */
    public String getNote() {
        return note;
    }

    /**
     * 函数名：setNote
     * 功能：设置备注
     * 返回值：note
     */
    public void setNote(String note) {
        this.note = note;
    }
}
