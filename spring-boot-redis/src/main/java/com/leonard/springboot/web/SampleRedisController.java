package com.leonard.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leonard on 2016/7/6.
 */
@RestController
public class SampleRedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestParam String key, @RequestParam String value) {
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        redis.set(key, value);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get(@RequestParam String key) {
        ValueOperations<String, String> redis = redisTemplate.opsForValue();
        String value = redis.get(key);
        return value;
    }

}
