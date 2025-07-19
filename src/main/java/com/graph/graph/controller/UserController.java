package com.graph.graph.controller;

import com.github.pagehelper.PageInfo;
import com.graph.graph.common.Result;
import com.graph.graph.entiey.User;
import com.graph.graph.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //增加数据
    @PostMapping("/add")
    public Result add(@RequestBody User user){
        userService.add(user);
        return Result.sucess();
    }

    //根据id删除
    @PostMapping("/deletebyid/{id}")
    public Result deleteByid(@PathVariable Integer id){
        userService.deleteByid(id);
        return Result.sucess();
    }

    //更新数据
    @PostMapping("/updata")
    public Result updata(@RequestBody User user){
        userService.updata(user);
        return Result.sucess();
    }

    //查询所有数据
    @GetMapping("/selectall")
    public Result selectAll(){
        List<User> list = userService.selectAll();
        return Result.sucess(list);
    }

    //根据id查询
    @GetMapping("/selectbyid")
    public Result selectById(@RequestParam Integer id){
        User list = userService.selectById(id);
        return Result.sucess(list);
    }

    //根据名称查询
    @GetMapping("selectbyname")
    public Result selectByName(@RequestParam String name){
        List<User> res = userService.selectByName(name);
        return Result.sucess(res);
    }

    //分页查询
    //pageNum 当前页码
    //pageSize 每页的数据量
    //TODO 分页查询逻辑要更精简
    @GetMapping("/selectpage")
    public Result selectPage(@RequestParam(defaultValue = "1") Integer pageNum,
                            @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<User> info = userService.selectPage(pageNum,pageSize);
        return Result.sucess(info);
    }


}
