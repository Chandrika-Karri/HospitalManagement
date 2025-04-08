package com.hospital.hospitalmanagement.repository;

import com.hospital.hospitalmanagement.domain.Patient;

public interface CustomPatientRepository {

    public Patient findBySSN(Long ssn);
}
