package com.spring.session.example.springsessionexample.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("inclusion")
public class Novel {

    private int id;

    private String title;

    private String author;

    private ContractData contractData;

}