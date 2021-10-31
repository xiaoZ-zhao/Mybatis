package com.zhao.dao;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoText {

    static Logger logger = Logger.getLogger(UserDaoText.class);


    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 第一种：mapper.getUserLike("%王%"); 防止sql注入
        logger.info("测试：进入了getUserById方法");
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        logger.info("info:进入testLog4j方法");
        logger.debug("debug:进入testLog4j方法");
        logger.error("error:进入testLog4j方法");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map=new HashMap();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList=userMapper.getUserByLimit(map);
        for (User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
}
