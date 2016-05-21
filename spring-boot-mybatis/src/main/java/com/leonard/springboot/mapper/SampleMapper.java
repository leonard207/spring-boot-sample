package com.leonard.springboot.mapper;

import com.leonard.springboot.domain.Sample;

import java.util.List;

/**
 * Created by Leonard on 2016/5/21.
 */
public interface SampleMapper {

    Sample selectSampleById(int id);

    List<Sample> selectSampleList();
}
