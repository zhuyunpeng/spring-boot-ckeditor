package com.example.ckeditortest.config;

import java.io.Serializable;


/**
 * Created by zhuyunpeng on 2018/01/19
 **/
public class Event implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}