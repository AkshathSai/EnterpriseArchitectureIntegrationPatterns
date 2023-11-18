package com.example.springeaiapachecamelservice1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//Commented to disable the route
//@Component
public class MyFirstRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //queue
        //transformation
        //database

        //timer
        //transformation
        //log
        from("timer:first-timer") //timer
                //.transform().constant("My Constant Message")
                //.transform().constant("Time now is " + LocalDateTime.now())
                .bean("getCurrentTimeBean") // This is invoking the GetCurrentTimeBean.java class [Note: Bean names use Spring Beans naming convention here]
                .bean("getCurrentTimeBean", "getCurrentTime")
                .to("log:first-timer"); //database
    }

}