package com.quickcare.controller;

import com.quickcare.entity.Doctor;
import com.quickcare.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/saveDoctor")
    public ResponseEntity<Doctor>saveDoctor(
            @RequestBody Doctor doctor
            ){
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDoctor);
    }

    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<Doctor>>getAllDoctors(
    ){
        List<Doctor> allDoctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(allDoctors);
    }

    @GetMapping("/getDoctor/{id}")
    public ResponseEntity<Optional<Doctor>> getDoctorById(
            @PathVariable Long id
    ){
        Optional<Doctor> doctorById = doctorService.getDoctorById(id);
        return  ResponseEntity.ok(doctorById);
    }

    @PutMapping("/updateDoctor/{id}")
    public ResponseEntity<Doctor>updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctor doctor
    ){
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedDoctor);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ResponseEntity<Doctor>deleteDoctor(
            @PathVariable Long id
    ){
        doctorService.deletDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
