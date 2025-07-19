package com.graph.graph.controller;

import com.graph.graph.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public Result test(){
        int a = 10 / 0;
        return Result.sucess(a);
    }
}
