package com.threadclub.sample.controller.vo;

import com.threadclub.controller.vo.BaseVo;
import com.threadclub.sample.entity.Sample;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SampleVo extends BaseVo<Sample> {

    private String name;
    private String color;

    public SampleVo(Sample sample) {
        if (sample != null) {
            this.name = sample.getName();
            this.color = sample.getColor();
        }
    }

    @Override
    public void copy(Sample sample) {
        if (sample != null) {
            this.name = sample.getName();
            this.color = sample.getColor();
        }
    }
}
