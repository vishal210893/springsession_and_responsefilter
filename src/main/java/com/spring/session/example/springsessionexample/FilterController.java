package com.spring.session.example.springsessionexample;

import com.spring.session.example.springsessionexample.entity.CommonMacList;
import com.spring.session.example.springsessionexample.entity.ContractData;
import com.spring.session.example.springsessionexample.entity.LedInfo;
import com.spring.session.example.springsessionexample.entity.Novel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FilterController {

    @RequestMapping("/novels")
    public ResponseEntity<Novel> novel() {

        CommonMacList commonMacList = new CommonMacList();
        commonMacList.setMac("abc");
        commonMacList.setShortAddr(100);
        commonMacList.setChecksum(25);
        CommonMacList commonMacList1 = new CommonMacList();
        commonMacList1.setMac("abc");
        commonMacList1.setShortAddr(100);
        commonMacList1.setChecksum(65);

        ArrayList<CommonMacList> ar = new ArrayList<>();
        ar.add(commonMacList);
        ar.add(commonMacList1);

        ContractData contractData = new ContractData();
        contractData.setChecksum(888);
        contractData.setJobNum("hello");
        contractData.setMacList(ar);

        Novel novel = new Novel();
        novel.setId(3);
        novel.setTitle("Last summer");
        novel.setAuthor("M.K");
        novel.setContractData(contractData);

        return ResponseEntity.ok().body(novel);
    }

    @RequestMapping("/ledinfo")
    public ResponseEntity<LedInfo> led() {

        LedInfo ledInfo = new LedInfo();
        ledInfo.setColor(LedInfo.LabelLedColor.BLUE);
        ledInfo.setPattern("RGB");
        ledInfo.setProductInfo("Dairy");
        ledInfo.setDuration(LedInfo.BlickingDurationTime.MINUTE_5);
        return ResponseEntity.ok().body(ledInfo);
    }


/*    @RequestMapping("/novelFilterWithoutControllerAdvice")
    public ResponseEntity<MappingJacksonValue> novelFilterWithoutControllerAdvice(@RequestParam(name = "include") String[] include) {

        CommonMacList commonMacList = new CommonMacList();
        commonMacList.setMac("abc");
        commonMacList.setShortAddr(100);
        commonMacList.setChecksum(25);
        CommonMacList commonMacList1 = new CommonMacList();
        commonMacList1.setMac("abc");
        commonMacList1.setShortAddr(100);
        commonMacList1.setChecksum(65);

        ArrayList<CommonMacList> ar = new ArrayList<>();
        ar.add(commonMacList);
        ar.add(commonMacList1);

        ContractData contractData = new ContractData();
        contractData.setChecksum(888);
        contractData.setJobNum("hello");
        contractData.setMacList(ar);

        Novel novel = new Novel();
        novel.setId(3);
        novel.setTitle("Last summer");
        novel.setAuthor("M.K");
        novel.setContractData(contractData);

        MappingJacksonValue res = new MappingJacksonValue(novel);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(include);
        FilterProvider provider = new SimpleFilterProvider().addFilter("inclusion", filter);
        res.setFilters(provider);
        return ResponseEntity.ok().body(res);
    }*/

}