package com.example.asyncdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/test")
public class AsyncController {

    @GetMapping
    public CompletableFuture<String> get() {
        return CompletableFuture.completedFuture("value");
    }
}
