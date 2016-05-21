package com.leonard.springboot.service;

import com.leonard.springboot.Application;
import com.leonard.springboot.domain.Sample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Leonard on 2016/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class SampleServiceTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void selectSampleByIdTest() {
        Sample sample = sampleService.selectSampleById(1);
        System.out.println(sample);
    }

    @Test
    public void selectSampleListTest() {
        Map<String,Object> reqMap = new HashMap<String,Object>();
        reqMap.put("offset",1);
        reqMap.put("limit",3);
        List<Sample> list = sampleService.selectSampleList(reqMap);
        for (Sample sample : list) {
            System.err.println(sample);
        }
        System.err.println(list.size());
    }
}
