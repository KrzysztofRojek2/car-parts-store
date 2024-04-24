package com.example.projekt1.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "car_model")
    private CarModel carModel;

}