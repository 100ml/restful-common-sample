package com.threadclub.sample.controller.vo;

import com.threadclub.sample.entity.Sample;
import lombok.Data;

@Data
public class SampleVo {

    private String name;
    private String color;

    public SampleVo(Sample sample) {
        if (sample != null) {
            this.name = sample.getName();
            this.color = sample.getColor();
        }
    }
}
