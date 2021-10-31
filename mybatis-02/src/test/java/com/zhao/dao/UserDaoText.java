package com.zhao.dao;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoText {

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 第一种：mapper.getUserLike("%王%"); 防止sql注入
        List<User> userList= mapper.getUserList();
        for ( User user:userList) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }


}
