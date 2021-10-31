import com.zhao.dao.UserMapper;
import com.zhao.pojo.User;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        SqlSession sqlSession2= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2=sqlSession2.getMapper(UserMapper.class);

        User user=mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        System.out.println("=======================");
        User user2=mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println(user==user2);

        sqlSession2.close();
    }
}
