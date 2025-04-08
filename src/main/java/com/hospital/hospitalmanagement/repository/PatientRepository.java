package com.hospital.hospitalmanagement.repository;

import com.hospital.hospitalmanagement.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient,Long> {

    public Patient findBySsn(Long ssn);

}