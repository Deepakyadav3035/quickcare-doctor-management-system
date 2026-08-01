package com.quickcare.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;


    @Column(name = "mobile", nullable = false, unique = true, length = 15)
    private String mobile;


    @Column(name = "specialization", nullable = false, length = 100)
    private String specialization;


    @Column(name = "experience", nullable = false)
    private Integer experience;


    @Column(name = "qualification", nullable = false, length = 100)
    private String qualification;


    @Column(name = "consultation_fee", nullable = false, precision = 10, scale = 2)
    private BigDecimal consultationFee;


    @Column(columnDefinition = " BOOLEAN DEFAULT TRUE")
    private Boolean available = true;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;





}