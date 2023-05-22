package com.example.assignment1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class Survey {
    private static final int QUESTION_COUNT = 3;

    private ArrayList<HashMap<String, Integer>> res = new ArrayList<>();
    // private HashMap<String, Integer> q1 = new HashMap<>();
    // private HashMap<String, Integer> q2 = new HashMap<>();
    // private HashMap<String, Integer> q3 = new HashMap<>();

    // http://localhost:8080/survey/?fav_place=%EB%AF%B8%EC%A0%95&travel_factors=travel_factors_etc&accommodation_type=camping

    @GetMapping("/survey/")
    public void save(@RequestParam() String fav_place, @RequestParam() String travel_factors, @RequestParam() String accommodation_type) {
        if (res.isEmpty()) { // init.
            for (int i = 0; i < QUESTION_COUNT; ++i) {
                res.add(new HashMap<>());
            }

            res.get(1).put("price", 0);
            res.get(1).put("tourist_spots", 0);
            res.get(1).put("food", 0);
            res.get(1).put("travel_factors_etc", 0);

            res.get(2).put("hotel", 0);
            res.get(2).put("airbnb", 0);
            res.get(2).put("camping", 0);
            res.get(2).put("accommodation_type_etc", 0);
        }

        if (!res.get(0).containsKey(fav_place)) {
            res.get(0).put(fav_place, 0);
        }

        res.get(0).replace(fav_place, res.get(0).get(fav_place) + 1);
        res.get(1).replace(travel_factors, res.get(1).get(travel_factors) + 1);
        res.get(2).replace(accommodation_type, res.get(2).get(accommodation_type) + 1);
    }

    @GetMapping("/survey")
    public ArrayList<HashMap<String, Integer>> getRes() {
        return res;
    }
}
