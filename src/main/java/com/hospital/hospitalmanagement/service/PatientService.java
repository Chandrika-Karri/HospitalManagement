package com.hospital.hospitalmanagement.service;

import com.hospital.hospitalmanagement.dao.PatientDAO;
import com.hospital.hospitalmanagement.domain.Patient;
import com.hospital.hospitalmanagement.repository.CustomPatientRepository;
import com.hospital.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService implements CustomPatientRepository {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private PatientRepository patientRepository;

    public Object findAll(){
        return patientRepository.findAll();
    }

    public Patient findById(Long id){
        return patientRepository.findById(id).orElse(null);
    }

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient findBySSN(Long ssn){
        return findBySSN(ssn);
    }

}
