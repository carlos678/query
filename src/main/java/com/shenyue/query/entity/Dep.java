package com.shenyue.query.entity;

import java.io.Serializable;

/**
 * Dep表的实体类
 */
public class Dep implements Serializable {
    private int id;
    private String name;
    private String address;
    private int num;

    @Override
    public String toString() {
        return "Dep{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", num=" + num +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
