package com.zhao.pojo;

import lombok.Data;

import java.util.Date;

@Data

public class Blog {

    private String id;
    private String title;
    private String author;
    //属性名和字段名不一致
    private Date createTime;
    private int views;

}
