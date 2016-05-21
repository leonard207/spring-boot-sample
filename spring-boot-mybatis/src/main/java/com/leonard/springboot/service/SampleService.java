package com.leonard.springboot.service;

import com.leonard.springboot.domain.Sample;
import java.util.List;
import java.util.Map;

/**
 * Created by Leonard on 2016/5/21.
 */
public interface SampleService {

    Sample selectSampleById(int id);

    List<Sample> selectSampleList(Map<String,Object> reqMap);
}
