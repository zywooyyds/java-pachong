package com.ck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @BelongsProject: java-pachong
 * @BelongsPackage: com.ck.controller
 * @Author: lp
 * @CreateTime: 2023-01-18  09:39
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
public class HelloWorld {
    @ResponseBody
    @RequestMapping("/hello")
    public  String hello() {
        return  "Hello World...";
    }
}
