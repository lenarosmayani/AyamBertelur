package com.example.Chickens.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Chickens.Model.Chicken;
import com.example.Chickens.Service.ChickenService;

@RestController
@RequestMapping("/api/chickens")
public class ChickenController {

    @Autowired
    private ChickenService chickenService;

    @PostMapping
    public ResponseEntity<Chicken> addChicken(@RequestBody Chicken chicken) {
        return ResponseEntity.status(HttpStatus.CREATED).body(chickenService.addChicken(chicken));
    }

    @GetMapping
    public ResponseEntity<List<Chicken>> getAllChickens() {
        return ResponseEntity.ok(chickenService.getAllChickens());
    }

    @GetMapping("/earnings")
    public ResponseEntity<String> getTotalEarnings() {
        String totalEarningsMessage = chickenService.getTotalEarningsMessage();
        return ResponseEntity.ok(totalEarningsMessage);
    }
}