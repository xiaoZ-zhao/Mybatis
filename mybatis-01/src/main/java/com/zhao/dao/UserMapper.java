package com.zhao.dao;

import com.zhao.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    //查询全部用户
    List<User> getUserList();

    //添加用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

}


  /*  //根据id查询用户
    User getUserById(int id);
    //模糊查询
    List<User> getUserLike(String value);
    //万能的Map
    int addUser2(Map<String, Object> map);*/

