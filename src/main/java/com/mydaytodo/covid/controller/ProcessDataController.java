package com.mydaytodo.covid.controller;

import com.mydaytodo.covid.models.CovidCase;
import com.mydaytodo.covid.models.Dataset;
import com.mydaytodo.covid.service.CSVParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("data")
public class ProcessDataController {

    @Autowired
    private CSVParser csvParser;

    @GetMapping("/raw")
    public Dataset parseToJson() {
        return csvParser.parseDataset("cnfrm_case_table4_location_likely_source.csv");
    }

    @GetMapping("/byPostcode/{postcode}")
    public Dataset casesByPostcode(@PathVariable("postcode") Integer postcode) {
        return csvParser.byPostcode(postcode);
    }
}