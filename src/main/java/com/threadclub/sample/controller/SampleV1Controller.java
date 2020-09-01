package com.threadclub.sample.controller;

import com.threadclub.controller.BaseController;
import com.threadclub.sample.controller.vo.SampleVo;
import com.threadclub.sample.service.SampleService;
import com.threadclub.sample.service.dto.SampleAddDto;
import com.threadclub.sample.service.dto.SampleQueryDto;
import com.threadclub.sample.service.dto.SampleUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/samples/v1")
public class SampleV1Controller extends BaseController {

    @Autowired
    private SampleService sampleService;

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid SampleAddDto addDto, BindingResult result) {
        return this.add(addDto, result, x -> sampleService.add(x));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid SampleUpdateDto updateDto,
                                  BindingResult result) {
        updateDto.setId(id);
        return this.update(updateDto, result, x -> sampleService.update(x));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return this.deleteById(id, x -> sampleService.delete(x));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(new SampleVo(sampleService.find(id)));
    }

    @GetMapping("/list")
    public ResponseEntity findList(SampleQueryDto queryDto) {
        return this.findList(queryDto, x -> sampleService.findList(x), SampleVo::new);
    }

    @GetMapping("/page")
    public ResponseEntity findPage(SampleQueryDto queryDto, @PageableDefault Pageable page) {
        return this.findPage(queryDto, page, (x, y) -> sampleService.findPage(x, y), SampleVo::new);
    }
}
