package com.example.demo.repository;

import com.example.demo.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGamesRepository extends JpaRepository<Games, Integer> {
}
