package com;

import com.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@EnableFeignClients
@SpringBootApplication(scanBasePackages = {"com"})
@EntityScan("com")
@EnableScheduling
public class ApplicationStarter {
    @Autowired
    OrderRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }




}
