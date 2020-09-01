package com.threadclub.sample.service.dto;

import com.threadclub.service.dto.UpdateDto;
import lombok.Data;

@Data
public class SampleUpdateDto extends UpdateDto {

    private String name;
    private String color;
}
