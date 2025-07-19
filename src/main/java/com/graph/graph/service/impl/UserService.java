package com.graph.graph.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graph.graph.entiey.User;
import com.graph.graph.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService implements com.graph.graph.service.UserService {

    @Resource
    private UserMapper usermapper;

    @Override
    public void add(User user) {
        usermapper.insert(user);
    }

    @Override
    public void updata(User user) {
        usermapper.updata(user);
    }

    @Override
    public void deleteByid(Integer id) {
        usermapper.deleteByid(id);
    }

    @Override
    public List<User> selectByName(String name) {
        List<User> res = usermapper.selectByName(name);
        return res;
    }


    @Override
    public List<User> selectAll() {
        List<User>list = usermapper.selectAll();
        return list;
    }

    @Override
    public User selectById(Integer id) {
        User user= usermapper.selectById(id);
        return user;
    }

    @Override
    public PageInfo<User> selectPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list = usermapper.selectAll();
        return PageInfo.of(list);
    }



}
