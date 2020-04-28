package com.threadclub.sample.entity;

import com.threadclub.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Sample extends BaseEntity {

    private String name;
    private String color;
}
