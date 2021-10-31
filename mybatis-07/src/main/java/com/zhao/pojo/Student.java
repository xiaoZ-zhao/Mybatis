package com.zhao.pojo;

import lombok.Data;

@Data
public class Student {

    private int id;
    private String name;
    //关联老师
    private Teacher teacher;
}
