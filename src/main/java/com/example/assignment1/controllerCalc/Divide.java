package com.example.assignment1.controllerCalc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Divide {
    @GetMapping("/calc/divide")
    public Double divide(@RequestParam() Integer x, @RequestParam() Integer y) {
        return (y == 0 ? null : x / (double) y);
    }
}
