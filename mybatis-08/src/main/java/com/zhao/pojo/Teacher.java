package com.zhao.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {

    private int id;
    private String name;
    //老师拥有多个学上
    private List<Student> students;
}
