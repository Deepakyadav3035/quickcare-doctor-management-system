package com.quickcare.service.impl;

import com.quickcare.entity.Doctor;
import com.quickcare.exception.ResourceNotFoundException;
import com.quickcare.repository.DoctorRepository;
import com.quickcare.service.DoctorService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Optional<Doctor> doctorByEmail = doctorRepository.findDoctorByEmail(doctor.getEmail());
        if(doctorByEmail.isPresent()){
            throw new RuntimeException("Email already exist !");
        }
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> allDoctors = doctorRepository.findAll();
        return allDoctors;
    }

    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        Optional<Doctor> doctorById = doctorRepository.findDoctorById(id);
        if(!doctorById.isPresent()){
            throw new ResourceNotFoundException("Doctor not found with this id " +id);
        }
        return doctorById;
    }

    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {
        Optional<Doctor> existingDoctor = doctorRepository.findDoctorById(id);
        if(!existingDoctor.isPresent()){
            throw new ResourceNotFoundException("Doctor not found with this id " +id);
        }
        Doctor updatedDoctor = existingDoctor.get();
        updatedDoctor.setFullName(doctor.getFullName());
        updatedDoctor.setEmail(doctor.getEmail());
        updatedDoctor.setMobile(doctor.getMobile());
        updatedDoctor.setSpecialization(doctor.getSpecialization());
        updatedDoctor.setExperience(doctor.getExperience());
        updatedDoctor.setQualification(doctor.getQualification());
        updatedDoctor.setConsultationFee(doctor.getConsultationFee());
        updatedDoctor.setAvailable(doctor.getAvailable());
        updatedDoctor.setUpdatedAt(doctor.getUpdatedAt());

        Doctor doctor1 = doctorRepository.save(updatedDoctor);
        return doctor1;
    }

    @Override
    public void deletDoctor(Long id) {
        Optional<Doctor> doctorById = doctorRepository.findDoctorById(id);
        if(!doctorById.isPresent()){
            throw new ResourceNotFoundException("Doctor not found with this id "+ id);
        }
        doctorRepository.deleteById(id);

    }
}
