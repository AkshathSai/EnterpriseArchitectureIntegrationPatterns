package com.example.springeaiapachecamelservice1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //timer
        /*from("timer:my-timer?period=10000")
                .transform().constant("My message for Active MQ")
                .log("${body}")
                .to("activemq:my-activemq-queue");*/
        //queue

        from("file:files/json")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
