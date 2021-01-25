package com.offcn.dao;

import com.offcn.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();
    List<User> selectById(int id);
    int  addUser(User user);
    int delete(int id);
    //    通过id修改学员信息
    int updateUser(User user);
    //    统计班级人数
    int num();
}
