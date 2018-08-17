package com.test.springboot.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConferenceApplication {

    ConferenceApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(ConferenceApplication.class, args);
    }

}