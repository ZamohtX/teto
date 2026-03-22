package com.teto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String test() {
        return "No auth required";
    }
    @GetMapping("/auth")
    public String testAuth() {
        return "Auth required";
    }
    @GetMapping("/auth-admin")
    public String testAuthAdmin() {
        return "Auth required with admin role";
    }

}
