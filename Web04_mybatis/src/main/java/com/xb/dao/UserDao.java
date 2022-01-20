package com.xb.dao;

import com.xb.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
//    查询所有数据
    List<User> findAll();
//    增加一条数据
    int addUser(User user);
//    查询一条数据
    User findOneById(Integer id);
//    修改一条数据
    void updateUser(User user);
//    删除一条数据
    int deleteById(Integer id);
//    用户名模糊查询
    List<User> findByUsername(String username);


}
