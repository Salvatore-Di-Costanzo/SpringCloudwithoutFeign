package com.example.servicemain.util;


import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
public class SpringEurekaClientServiceMain implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("details",
                Collections.singletonMap("description", "This is the Main Service, which is discovery server aware, and this service will Call Student Microservice and School Microservice, from student details, which is again dicovery server aware!!! "));
    }
}
