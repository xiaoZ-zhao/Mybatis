import com.zhao.dao.TeacherMapper;
import com.zhao.pojo.Teacher;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        TeacherMapper mapper=sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher=mapper.getTeacher2(1);
        System.out.println(teacher);
        sqlSession.close();
    }


}
