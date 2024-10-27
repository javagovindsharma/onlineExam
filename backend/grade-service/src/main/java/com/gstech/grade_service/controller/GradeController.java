package com.gstech.grade_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @GetMapping("/test")
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Welcome to Staff Service");
    }
}