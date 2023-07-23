package com.example.ExpenseTrackerAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(unique = true , nullable = false)
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @Column(nullable = false)
    @NotEmpty
    private String title;
    @Column(nullable = false)
    @NotEmpty
    private String description;
    @NotBlank
    private Double price;
    @Column(nullable = false)
    private LocalDateTime expenseDateTime;

}
