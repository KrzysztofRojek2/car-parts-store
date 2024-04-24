package com.example.projekt1.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@With
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CarModel model;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @ManyToOne
    private Client client;

}
