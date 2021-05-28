package com.spring.session.example.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonFilter("inclusion")
public class ContractData {

    private String jobNum;

    private int checksum;

    private ArrayList<CommonMacList> macList = new ArrayList<>();

}
