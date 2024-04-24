package com.example.projekt1.repo;

import com.example.projekt1.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    long count();
    long countByPartId(Long productId);
    long countByClientId(Long clientId);
}
