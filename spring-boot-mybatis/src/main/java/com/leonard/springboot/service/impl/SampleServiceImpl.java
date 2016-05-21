package com.leonard.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.leonard.springboot.domain.Sample;
import com.leonard.springboot.mapper.SampleMapper;
import com.leonard.springboot.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Leonard on 2016/5/21.
 */
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private SampleMapper sampleMapper;

    @Override
    public Sample selectSampleById(int id) {
        return sampleMapper.selectSampleById(id);
    }

    @Override
    public List<Sample> selectSampleList(Map<String,Object> reqMap) {
        int offset = Integer.parseInt(String.valueOf(reqMap.get("offset")));
        int limit = Integer.parseInt(String.valueOf(reqMap.get("limit")));
        PageHelper.startPage(offset, limit);
        return sampleMapper.selectSampleList();
    }
}
