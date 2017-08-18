package com.jasonswitzer.driverslicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonswitzer.driverslicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{

}
