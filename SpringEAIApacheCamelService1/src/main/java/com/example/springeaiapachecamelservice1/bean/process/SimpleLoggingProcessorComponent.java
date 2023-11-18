package com.example.springeaiapachecamelservice1.bean.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleLoggingProcessorComponent {

    public void process(String message) {
        log.info("SimpleLoggingProcessorComponent {}", message);
    }

}
