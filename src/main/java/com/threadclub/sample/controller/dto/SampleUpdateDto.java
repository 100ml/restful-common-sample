package com.threadclub.sample.controller.dto;

import com.threadclub.controller.dto.UpdateDto;
import lombok.Data;

@Data
public class SampleUpdateDto extends UpdateDto {

    private String name;
    private String color;
}
