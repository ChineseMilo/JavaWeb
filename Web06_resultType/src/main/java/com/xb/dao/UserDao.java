package com.xb.dao;

import com.xb.pojo.User;
import com.xb.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<UserInfo> findAll();

//    根据address查询用户,如果没有传入地址则查询出所有用户
    List<User> findUserListByAddress(@Param("address") String address);
//    根据用户的地址和性别查询用户, 如果有address才考虑address的条件，如果有sex才考虑sex的 条件
    List<User> findUserListByAddressAndSex(User user);

    void deleteId(List<Integer> ids);
}
