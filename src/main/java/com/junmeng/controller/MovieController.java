package com.junmeng.controller;

import com.junmeng.entity.User;
import com.junmeng.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by james on 2018/3/14.
 */
@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return this.userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return this.userFeignClient.getUser(user);
    }

}
