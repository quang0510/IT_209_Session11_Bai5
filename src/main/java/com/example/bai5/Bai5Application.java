package com.example.bai5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Bai5Application {

    public static void main(String[] args) {
        SpringApplication.run(Bai5Application.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Spring Boot CI/CD Pipeline with GitHub Actions and Docker!";
    }
}
