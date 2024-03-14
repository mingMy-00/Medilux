package com.group.medilux.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NowiJController {
    @GetMapping("/nowij")
    public String Nowij() {
        return "String Boot 연동 ";
    }
}
