package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}