package com.example.Chickens.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Chickens.Model.Chicken;
import com.example.Chickens.Repository.ChickenRepository;

@Service
public class ChickenService {

    @Autowired
    private ChickenRepository chickenRepository;

    public Chicken addChicken(Chicken chicken) {
        return chickenRepository.save(chicken);
    }

    public List<Chicken> getAllChickens() {
        return chickenRepository.findAll();
    }

    public String getTotalEarningsMessage() {
        double totalEarnings = calculateTotalEarnings();
        return "Total earnings : " + totalEarnings;
    }

    private double calculateTotalEarnings() {
        return chickenRepository.findAll().stream()
            .mapToDouble(chicken -> chicken.getEggsLaid() * chicken.getPricePerEgg())
            .sum();
    }
    
}
