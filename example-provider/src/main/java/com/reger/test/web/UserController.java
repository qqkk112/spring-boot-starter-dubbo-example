package com.reger.test.web;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by Tian Jiguang on 2018/06/17.
*/
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return "342342342143";
    }
}
