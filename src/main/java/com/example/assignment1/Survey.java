package com.example.assignment1;

import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
public class Survey {
    private static final int QUESTION_COUNT = 3;
    private static final String[] TRAVEL_FACTORS = { "price", "tourist_spots", "food", "etc" };
    private static final String[] ACCOMMODATION_TYPE = { "hotel", "airbnb", "camping", "etc" };

    private ArrayList<HashMap<String, Integer>> res = new ArrayList<>();

    private ArrayList<String> simpleParser(final String messageBody) {
        var parsedData = new ArrayList<String>();
        var list = messageBody.split("&"); // len : 3

        for (int i = 0; i < list.length; ++i) {
            var temp = list[i].split("=");

            parsedData.add(temp[1]); // 0 : key, 1 : value.
        }

        // System.out.println(new String(list[0].getBytes(StandardCharsets.UTF_16)));

        return parsedData;
    }

    @PostMapping("/survey")
    public void save(@RequestBody String messageBody) {
        if (res.isEmpty()) { // init.
            for (int i = 0; i < QUESTION_COUNT; ++i) {
                res.add(new HashMap<>());
            }
        }

        var parsedData = simpleParser(messageBody);

        for (int i = 0; i < parsedData.size(); ++i) {
            if (!res.get(i).containsKey(parsedData.get(i))) {
                res.get(i).put(parsedData.get(i), 0);
            }

            res.get(i).replace(parsedData.get(i), res.get(i).get(parsedData.get(i)) + 1);
        }
    }

    @GetMapping("/survey")
    public ArrayList<HashMap<String, Integer>> getRes() {
        return res;
    }
}
