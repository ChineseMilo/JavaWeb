package com.xu.dao;

import com.xb.dao.UserDao;
import com.xb.pojo.User;
import com.xb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class UserDaoTest {
    @Test
    public void findAll(){
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        System.out.println(mapper.findAll());
        SqlSessionFactoryUtil.commitAndClose(sqlsession);
    }

    @Test
    public void findUserListByAddress(){
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        System.out.println(mapper.findUserListByAddress("苏州"));
        SqlSessionFactoryUtil.commitAndClose(sqlsession);
    }

    @Test
    public void findUserListByAddressAndSex(){
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        System.out.println(mapper.findUserListByAddressAndSex(new User(null,null,"男",null,"苏州")));
        SqlSessionFactoryUtil.commitAndClose(sqlsession);
    }

    @Test
    public void deleteId(){
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        List<Integer> list= new ArrayList<>();
        list.add(9);
        list.add(11);

        mapper.deleteId(list);
        SqlSessionFactoryUtil.commitAndClose(sqlsession);
    }

}
