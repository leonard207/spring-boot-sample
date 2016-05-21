package com.leonard.springboot.web;

import com.leonard.springboot.domain.Sample;
import com.leonard.springboot.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Leonard on 2016/5/21.
 */
@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping
    public List<Sample> getAll() {
        Map<String,Object> reqMap = new HashMap<String,Object>();
        reqMap.put("offset",1);
        reqMap.put("limit",3);
        List<Sample> list = sampleService.selectSampleList(reqMap);
        return list;
    }
}
