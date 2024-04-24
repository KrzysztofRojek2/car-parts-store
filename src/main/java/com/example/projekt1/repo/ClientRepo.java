package com.example.projekt1.repo;

import com.example.projekt1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}