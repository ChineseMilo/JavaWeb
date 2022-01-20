package com.xb;


import com.xb.dao.UserDao;
import com.xb.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestMybatis {
    private UserDao mapper;
    private SqlSession openSession;
    private InputStream is;

    @Before
    public void factory() throws IOException {
        String resource = "mybatis-Config.xml";
        is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        openSession = sqlSessionFactory.openSession();
        mapper = openSession.getMapper(UserDao.class);

    }

/*
* SqlSession代表和数据库的一次会话，用完必须关闭
* SqlSession和Connection都是线程非安全的，每一次都应该获取新的对象
* getMapper：mapper没有实现类，mybatis会为这个接口生成一个动态代理对象（将接口和xml绑定）
*
* SqlSessionFactory：根据xml配置文件（全局配置文件）获取到一个SqlSessionFactory对象，包含了一些数据源和运行环境的信息
* sql映射文件：配置了每一个sql，以及封装规则等
* 使用sql唯一标识来告诉mybatis去执行那个sql语句，sql都是保存在sql映射文件中的
*
* */
    @Test
    public void  test01() throws IOException {


//        获取接口实现类代理对象
//            获取接口实现类对象

        List<User> userList = mapper.findAll();

        try {
            for (User user : userList) {
                System.out.println(user);
            }
        } finally {

        }


    }

    @Test
    public void addUser() throws IOException {
        User user = new User(null, "ll", "男", new Date(), "11111");
        int i = mapper.addUser(user);
        System.out.println(user.getUid());

    }

    @Test
    public void findOneById(){
        System.out.println(mapper.findOneById(1));
    }

    @Test
    public void updateUser(){

        Map<String,Object> map = new HashMap<>();
        map.put("uid",1);
        map.put("username","张三");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","123dsf");

        mapper.updateUser(map);


    }

    @Test
    public void deleteById(){
        int i = mapper.deleteById(10);
        System.out.println(i);
    }

    @Test
    public void findByUsername(){
        System.out.println(mapper.findByUsername("s"));
    }

    @Test
    public void searchUserByUsernameAndAddress(){
        System.out.println(mapper.searchUserByUsernameAndAddress("张三", "123dsf"));
    }

    @After
    public void destroy() throws IOException {
        openSession.commit();
        openSession.close();
        is.close();
    }

}
