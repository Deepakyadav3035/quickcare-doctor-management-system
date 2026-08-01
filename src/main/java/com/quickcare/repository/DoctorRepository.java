package com.quickcare.repository;

import com.quickcare.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    List<Doctor> email(String email);
    Optional<Doctor>findDoctorByEmail(String email);

    Optional<Doctor> findDoctorById(Long id);
}
