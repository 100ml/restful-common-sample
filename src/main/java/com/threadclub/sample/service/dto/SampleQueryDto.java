package com.threadclub.sample.service.dto;

import com.threadclub.service.dto.QueryDto;
import lombok.Data;

@Data
public class SampleQueryDto extends QueryDto {

    private String name;
    private String color;
}
