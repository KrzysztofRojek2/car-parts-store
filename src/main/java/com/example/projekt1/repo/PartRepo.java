package com.example.projekt1.repo;

import com.example.projekt1.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepo extends JpaRepository<Part, Long> {
    List<Part> findByPriceBetween(Double minPrice, Double maxPrice);
}