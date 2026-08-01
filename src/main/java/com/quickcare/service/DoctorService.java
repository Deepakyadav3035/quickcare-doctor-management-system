package com.quickcare.service;

import com.quickcare.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    List<Doctor> getAllDoctors();

    Optional<Doctor> getDoctorById(Long id);

    Doctor updateDoctor(Long id, Doctor doctor);

    void deletDoctor(Long id);
}
