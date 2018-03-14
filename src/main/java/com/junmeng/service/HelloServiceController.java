package com.junmeng.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * Created by james on 2018/3/14.
 */
@RestController
@RequestMapping("/feign-service")
public class HelloServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private void sleep(String methodName) {
        int sleepMinTime = new Random().nextInt(3000);
        logger.info("helloService " + methodName + " sleepMinTime: " + sleepMinTime);
        try {
            Thread.sleep(sleepMinTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/serviceGet", method = RequestMethod.GET)
    public String helloService(@RequestParam String name) {
        sleep("get");
        return "HelloServiceImpl name :" + name;
    }

    @RequestMapping(value = "/serviceHead", method = RequestMethod.HEAD)
    public String helloService(@RequestHeader String name,
                               @RequestHeader String password) {
        sleep("header");
        return "helloServiceHead name :" + name + " password:" + password;
    }

    @RequestMapping(value = "/servicePost", method = RequestMethod.POST)
    public String helloService(@RequestBody UserDemo userDemo) {
        sleep("post");
        return userDemo.toString();
    }
}
