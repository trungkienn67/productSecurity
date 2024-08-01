package com.example.productsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContentController {
    @GetMapping("/login")
    public String handleLogin() {
        return "maintenances/custom_login"; // Trả về tên view "login"
    }
    @GetMapping("/logout")
    public String handleError() {
        // Do something like logging
        return "maintenances/custom_logout"; // Return a view named 'error'
    }
}
