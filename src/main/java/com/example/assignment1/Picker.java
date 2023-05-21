package com.example.assignment1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Picker {
    private int count;
    private HashMap<String, Integer> map = new HashMap<>(); // memory repo.

    public void addDummy() {
        map.put("susi", 2);
        map.put("burger", 1);
        map.put("pork", 3);
        map.put("toast", 1);

        count = 7;
    }

    @GetMapping("/picker")
    public String pick() {
        if (map.size() == 0) {
            addDummy();
        }

        double rand = Math.random();

        double weight = 1.0 / count;
        double sum = 0;

        for (var candidate : map.keySet()) {
            sum += map.get(candidate) * weight;

            if (rand <= sum) return candidate;
        }

        return "rice";
    }

    @GetMapping("/picker/")
    public void add(@RequestParam() String text) {
        if (!map.containsKey(text)) {
            map.put(text, 0);
        }

        map.replace(text, map.get(text) + 1);
        count++;

        System.out.println(count);
    }
}
