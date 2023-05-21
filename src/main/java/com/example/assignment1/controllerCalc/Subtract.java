package com.example.assignment1.controllerCalc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Subtract {
    @GetMapping("/calc/subtract")
    public Integer subtract(@RequestParam() Integer x, @RequestParam() Integer y) {
        return x - y;
    }
}
