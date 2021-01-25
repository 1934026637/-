import com.offcn.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test1 {
    @Test
    public void m1() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlSessionConfig.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sf.openSession();
        List<User> userList = session.selectList("com.offcn.dao.UserMapper.selectAll");
        for (User user:userList){
            System.out.println(user);
        }
        session.commit();
        session.close();
    }


    @Test
    public void m2() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlSessionConfig.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sf.openSession();
        User user = sqlSession.selectOne("com.offcn.dao.UserMapper.selectById",1);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void m3() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlSessionConfig.xml");
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sf.openSession();
        User user = new User();
        user.setName("周隆莹");
        user.setSex(1);
        user.setAge(21);
        user.setAddress("运城");
        int i = session.insert("com.offcn.dao.UserMapper.addUser", user);
        System.out.println(i);
        session.commit();
        session.close();
    }
}
