package com.graph.graph.service;

import com.github.pagehelper.PageInfo;
import com.graph.graph.entiey.User;

import java.util.List;

public interface UserService {

    List<User> selectAll();

    User selectById(Integer id);

    PageInfo<User> selectPage(Integer pageNum,Integer pageSize);

    void add(User user);

    void updata(User user);

    void deleteByid(Integer id);

    List<User> selectByName(String name);
}
