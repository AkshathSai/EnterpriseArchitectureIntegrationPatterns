package com.example.springeaiapachecamelservice1.bean.transform;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimeBean {

    String getCurrentTime() {
        return "Time now is " + LocalDateTime.now();
    }
}
