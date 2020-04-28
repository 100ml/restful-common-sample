package com.threadclub.sample.service.impl;

import com.google.common.collect.Lists;
import com.threadclub.controller.dto.AddDto;
import com.threadclub.controller.dto.QueryDto;
import com.threadclub.controller.dto.UpdateDto;
import com.threadclub.sample.controller.dto.SampleAddDto;
import com.threadclub.sample.controller.dto.SampleQueryDto;
import com.threadclub.sample.controller.dto.SampleUpdateDto;
import com.threadclub.sample.entity.Sample;
import com.threadclub.sample.repository.SampleRepository;
import com.threadclub.sample.service.SampleService;
import com.threadclub.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.Predicate;
import java.util.List;

@Slf4j
@Service
public class SampleServiceImpl extends BaseServiceImpl<Sample> implements SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    @PostConstruct
    public void init() {
        this.setRepository(sampleRepository);
    }

    @Override
    protected <A extends AddDto> Sample from(A a) {
        SampleAddDto addDto = (SampleAddDto) a;
        Sample sample = new Sample();
        sample.setName(addDto.getName());
        sample.setColor(addDto.getColor());
        return sample;
    }

    @Override
    protected <U extends UpdateDto> void assignTo(U u, Sample sample) {
        SampleUpdateDto updateDto = (SampleUpdateDto) u;
        sample.setName(updateDto.getName());
        sample.setColor(updateDto.getColor());
    }

    @Override
    protected <Q extends QueryDto> Specification<Sample> assembleSpec(Q q) {
        SampleQueryDto queryDto = (SampleQueryDto) q;
        return (root, query, builder) -> {
            List<Predicate> predicates = Lists.newArrayList();
            if (!StringUtils.isEmpty(queryDto.getName())) {
                predicates.add(builder.like(root.get("name"), "%" + queryDto.getName() + "%"));
            }
            if (!StringUtils.isEmpty(queryDto.getColor())) {
                predicates.add(builder.like(root.get("color"), "%" + queryDto.getColor() + "%"));
            }
            predicates.add(builder.isFalse(root.get("isDeleted")));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
