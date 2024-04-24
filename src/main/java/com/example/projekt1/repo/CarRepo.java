package com.example.projekt1.repo;

import com.example.projekt1.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

    List<Car> findAllByDateBetween(LocalDate start, LocalDate end);
    long countCarByDateBetween(LocalDate start, LocalDate end);
}
