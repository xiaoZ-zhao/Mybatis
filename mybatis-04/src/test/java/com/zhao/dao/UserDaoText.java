package com.zhao.dao;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoText {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 第一种：mapper.getUserLike("%王%"); 防止sql注入
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }
// select  * from mybatis.user where id=#{id}
    //类型处理器
    // select  id,name,pwd as password  from mybatis.user where id=#{id}

}
