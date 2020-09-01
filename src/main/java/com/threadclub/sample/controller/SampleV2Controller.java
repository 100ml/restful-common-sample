package com.threadclub.sample.controller;

import com.threadclub.controller.SimpleController;
import com.threadclub.sample.entity.Sample;
import com.threadclub.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/samples/v2")
public class SampleV2Controller extends SimpleController {

    @Autowired
    private SampleService sampleService;

    @PostConstruct
    protected void setBaseService() {
        super.init(Sample.class, sampleService);
    }
}
