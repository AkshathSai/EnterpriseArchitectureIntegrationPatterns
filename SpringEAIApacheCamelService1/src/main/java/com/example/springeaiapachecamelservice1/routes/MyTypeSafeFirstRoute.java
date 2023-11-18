package com.example.springeaiapachecamelservice1.routes;

import com.example.springeaiapachecamelservice1.bean.process.SimpleLoggingProcessor;
import com.example.springeaiapachecamelservice1.bean.process.SimpleLoggingProcessorComponent;
import com.example.springeaiapachecamelservice1.bean.transform.GetCurrentTimeBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//Commented to disable the route
//@Component
public class MyTypeSafeFirstRoute extends RouteBuilder {

    @Autowired
    GetCurrentTimeBean getCurrentTimeBean;

    @Autowired
    SimpleLoggingProcessorComponent loggingProcessorComponent;

    @Override
    public void configure() throws Exception {
        from("timer:first-timer") //null
                .log("${body}") //null
                .transform().constant("My Constant Message")
                .log("${body}") //My Constant Message

                //Processing - Can be done by using either spring beans or process()
                //transformation - Can be done by using either spring beans or transform()
                // Transform has a return type whereas Process is of void type

                .bean(getCurrentTimeBean)
                .log("${body}") // Time now is 2023-11-17T00:26:07.820077
                //.bean(loggingProcessorComponent) //Spring Bean
                .process(new SimpleLoggingProcessor())
                .log("${body}")
                .to("log:first-timer"); //DB
    }
}

/*
@Component
public class MyTypeSafeFirstRoute extends RouteBuilder {

    @Autowired
    GetCurrentTimeBean getCurrentTimeBean;



    @Override
    public void configure() throws Exception {
        from("timer:first-timer") //timer
                //.transform().constant("My Constant Message")
                //.transform().constant("Time now is " + LocalDateTime.now())
                //.bean(getCurrentTimeBean)
                .bean(getCurrentTimeBean, "getCurrentTime")// This is invoking the GetCurrentTimeBean.java class [Note: Bean names use Spring Beans naming convention here]
                .to("log:first-timer"); //database
    }
}
*/
