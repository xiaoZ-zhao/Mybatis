package com.zhao.dao;

import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoText {

  /*  @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 第一种：mapper.getUserLike("%王%"); 防止sql注入
        List<User> userList= mapper.getUserLike("王");
        for ( User user:userList) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }*/



/*    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }*/



    /*    @Test
        public void addUser2(){
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("userid",4);
            map.put("userName","小王");
            map.put("password","456");

            mapper.addUser2(map);
            //提交事务
            sqlSession.commit();
            sqlSession.close();
        }*/
    //查询
    @Test
    public void getUserList() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //执行sql 方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        //List<User> userList = sqlSession.selectList("com.zhao.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }
        //故完毕sqlSession
        sqlSession.close();
    }
    //增删改需要添加事务
    //添加
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(7, "小王", "789456"));
        if (res > 0) {
            System.out.println("添加成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //更新
    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4, "王二", "456"));
        if (res > 0) {
            System.out.println("更新成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //删除
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(7);
        if (res > 0) {
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
