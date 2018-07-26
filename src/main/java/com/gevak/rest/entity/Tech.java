package com.gevak.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tech {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*Код підрозділу*/
    private String departmentCode;
    /*Найменування підрозділу*/
    private String departmentName;
    /*Код посади*/
    private String positionCode;
    /*Код ОВТ або МТЗ*/
    private String ovtMtzCode;
    /*Найменування посади ОВТ або МТЗ*/
    private String ovtMtzName;
    /*Код звання*/
    private String rankCode;
    /*Найменування звання*/
    private String rankName;
    /*Кількість штат*/
    private String amount;
    /*Одиниця виміру*/
    private String unit;

    public Tech() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getObtMtzCode() {
        return ovtMtzCode;
    }

    public void setObtMtzCode(String obtMtzCode) {
        this.ovtMtzCode = obtMtzCode;
    }

    public String getObtMtzName() {
        return ovtMtzName;
    }

    public void setObtMtzName(String obtMtzName) {
        this.ovtMtzName = obtMtzName;
    }

    public String getRankCode() {
        return rankCode;
    }

    public void setRankCode(String rankCode) {
        this.rankCode = rankCode;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", departmentCode='" + departmentCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", positionCode='" + positionCode + '\'' +
                ", obtMtzCode='" + ovtMtzCode + '\'' +
                ", obtMtzName='" + ovtMtzName + '\'' +
                ", rankCode='" + rankCode + '\'' +
                ", rankName='" + rankName + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
