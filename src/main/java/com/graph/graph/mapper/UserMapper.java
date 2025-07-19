package com.graph.graph.mapper;

import com.graph.graph.entiey.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectById(Integer id);

    void insert(User user);

    void updata(User user);

    void deleteByid(Integer id);

    List<User> selectByName(String name);
}
