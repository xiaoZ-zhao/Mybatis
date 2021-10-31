package com.zhao.utils;

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all") //抑制警告
public class IDutil {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDutil.getID());
        System.out.println(IDutil.getID());
        System.out.println(IDutil.getID());

    }
}
