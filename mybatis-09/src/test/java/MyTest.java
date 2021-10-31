import com.zhao.dao.BlogMapper;
import com.zhao.pojo.Blog;
import com.zhao.utils.IDutil;
import com.zhao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;


public class MyTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutil.getID());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutil.getID());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutil.getID());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutil.getID());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        //map.put("title","Java");
        map.put("author", "狂神说");
        List<Blog> blogList = mapper.queryBlogIF(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        map.put("title", "Java如此简单");
        map.put("author", "狂神说");
        map.put("id", 2);
        //map.put("views",9999);
        List<Blog> blogList = mapper.queryBlogChoose(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map = new HashMap();
        //map.put("title", "Java如此简单");
        map.put("author", "狂神说2");
        map.put("id", "897d2dc5941c49cbac2a62d88eb7ff66");
        //map.put("views",9999);
        mapper.updateBlog(map);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper mapper=sqlSession.getMapper(BlogMapper.class);
        HashMap map=new HashMap();
        ArrayList<Integer> ids=new ArrayList<Integer>();
        ids.add(1);

        map.put("ids",ids);
        List<Blog> blogList=mapper.queryBlogForeach(map);
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
