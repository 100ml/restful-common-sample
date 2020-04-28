package com.threadclub.sample.controller.dto;

import com.threadclub.controller.dto.QueryDto;
import lombok.Data;

@Data
public class SampleQueryDto extends QueryDto {

    private String name;
    private String color;
}
