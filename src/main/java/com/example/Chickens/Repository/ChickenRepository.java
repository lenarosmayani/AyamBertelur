package com.example.Chickens.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Chickens.Model.Chicken;

@Repository
public interface ChickenRepository extends JpaRepository<Chicken, Long> {
}
