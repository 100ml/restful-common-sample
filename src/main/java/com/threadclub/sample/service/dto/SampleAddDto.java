package com.threadclub.sample.service.dto;

import com.threadclub.service.dto.AddDto;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SampleAddDto extends AddDto {

    @NotNull(message = "name can not be null")
    private String name;
    @NotNull(message = "color can not be null")
    private String color;
}
