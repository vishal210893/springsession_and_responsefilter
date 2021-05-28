package com.spring.session.example.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("inclusion")
public class CommonMacList {

    private Integer shortAddr;

    private String mac;

    private int checksum;

}
