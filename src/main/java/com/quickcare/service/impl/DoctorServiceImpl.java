package com.quickcare.service.impl;

import com.quickcare.entity.Doctor;
import com.quickcare.repository.DoctorRepository;
import com.quickcare.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return List.of();
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return null;
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        return null;
    }

    @Override
    public void deletDoctor(Long id) {

    }
}
