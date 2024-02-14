package com.closetoyou.closetoyouapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongoAuditing
public class CloseToYouApiApplication {

//  TODO: unit tests, integration tests, readme, custom exceptions

    public static void main(String[] args) {
        SpringApplication.run(CloseToYouApiApplication.class, args);
    }
}
