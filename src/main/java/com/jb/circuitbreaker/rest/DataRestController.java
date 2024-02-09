package com.jb.circuitbreaker.rest;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRestController {

    @GetMapping("/data")
    @CircuitBreaker(fallbackMethod = "getDataFromDB", name = "octokit")
    public String getData() {
        System.out.println("redis method called..");

        int i = 10 / 0;

        return "Redis Data sent to u r email";
    }

    public String getDataFromDB(Throwable t) {
        System.out.println("db method called..");
        return "DB Data sent to u r email";
    }

}