package com.threadclub.sample.controller.dto;

import com.threadclub.controller.dto.AddDto;
import lombok.Data;

@Data
public class SampleAddDto extends AddDto {

    private String name;
    private String color;
}
