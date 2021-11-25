package com.wordpress.papatohu.papatohubackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloSpring {

    Logger logger = LoggerFactory.getLogger(HelloSpring.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Papatohu") String name) {
        logger.info("Request sent: " + name);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
