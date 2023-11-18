package com.example.springeaiapachecamelservice1.bean.process;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class SimpleLoggingProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        //log.info("Exchange {}", exchange);
        log.info("Exchange {}", exchange.getMessage().getBody());
    }
}
