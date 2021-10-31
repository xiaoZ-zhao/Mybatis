package com.zhao.dao;

import com.zhao.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //查询所有老师
    List<Teacher> getTeacher();

    //获取指定老师下的所有学上以及老师信息
    Teacher getTeacher(int id);
    Teacher getTeacher2(int id);
}
