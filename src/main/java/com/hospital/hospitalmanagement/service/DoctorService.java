package com.hospital.hospitalmanagement.service;


import com.hospital.hospitalmanagement.dao.DoctorDAO;
import com.hospital.hospitalmanagement.domain.Doctor;
import com.hospital.hospitalmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor findByName(String name){
        return doctorRepository.findByName(name);
    }

    public Doctor save(Doctor doctor){
        return doctorRepository.save(doctor);
    }
}
