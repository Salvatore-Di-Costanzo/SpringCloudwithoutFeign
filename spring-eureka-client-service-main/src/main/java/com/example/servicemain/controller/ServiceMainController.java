package com.example.servicemain.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ServiceMainController {

    @Autowired
    RestTemplate restTemplate;


    @RequestMapping(value = "/getSchool/{schoolname}", method = RequestMethod.GET)
    public String getSchool(@PathVariable String schoolname){
        log.info("Info della scuola: ");
        String response = restTemplate.exchange("http://school-service//getSchoolDetails/{schoolname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();

        log.info("Response Received as " + response);

        return response;
    }


    @RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
    public String getStrudent(@PathVariable String schoolname){
        log.info("Info Studenti: ");
        String response = restTemplate.exchange("http://student-service//getStudentDetailsForSchool/{schoolname}", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();
        log.info("Response Received as " + response);

        return response;
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
