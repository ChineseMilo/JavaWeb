package com.xb;

import com.xb.dao.UserDao;


import com.xb.pojo.QueryVo;
import com.xb.pojo.User;
import com.xb.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserDao {
    @Test
    public void updateUser(){
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("uid",2);
        map.put("username","张三");
        map.put("sex","男");
        map.put("birthday",new Date());
        map.put("address","123dsf");

        mapper.updateUser(map);

        SqlSessionFactoryUtil.commitAndClose(sqlsession);
    }

    @Test
    public void test02(){
        SqlSession sqlsession = SqlSessionFactoryUtil.getSqlsession();
        UserDao mapper = sqlsession.getMapper(UserDao.class);
        User user = new User();
        user.setSex("男");
        user.setAddress("苏州");
        QueryVo queryVo = new QueryVo(2L, 1, user);
        List<User> users = mapper.searchByCondition(queryVo);
//        System.out.println(users);
        for (User user1 : users) {
            System.out.println(user1);
        }
        SqlSessionFactoryUtil.commitAndClose(sqlsession);
    }
}
