package com.example.asyncdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class AsyncDemoApplication {

    @Bean
    public ShallowEtagHeaderFilter etagFilter() {
		return new ShallowEtagHeaderFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(AsyncDemoApplication.class, args);
    }
}
