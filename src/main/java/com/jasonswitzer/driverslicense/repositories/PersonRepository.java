package com.jasonswitzer.driverslicense.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jasonswitzer.driverslicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

}
