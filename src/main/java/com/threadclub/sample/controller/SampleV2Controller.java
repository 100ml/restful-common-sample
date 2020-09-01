package com.threadclub.sample.controller;

import com.threadclub.controller.SimpleController;
import com.threadclub.sample.controller.vo.SampleVo;
import com.threadclub.sample.entity.Sample;
import com.threadclub.sample.service.SampleService;
import com.threadclub.sample.service.dto.SampleAddDto;
import com.threadclub.sample.service.dto.SampleQueryDto;
import com.threadclub.sample.service.dto.SampleUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.function.Function;

@RestController
@RequestMapping("/samples/v2")
public class SampleV2Controller extends SimpleController {

    @Autowired
    private SampleService sampleService;

    @PostConstruct
    protected void setBaseService() {
        Function<Sample, SampleVo> voFunction = x -> new SampleVo(x);
        super.entityType(Sample.class)
                .updateDtoType(SampleUpdateDto.class)
                .addDtoType(SampleAddDto.class)
                .queryDtoType(SampleQueryDto.class)
                .service(sampleService)
                .voConverter(voFunction);
    }
}
