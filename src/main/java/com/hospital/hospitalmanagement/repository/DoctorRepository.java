package com.hospital.hospitalmanagement.repository;

import com.hospital.hospitalmanagement.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository  extends CrudRepository<Doctor,Long> {

    Doctor findByName(String name);
}