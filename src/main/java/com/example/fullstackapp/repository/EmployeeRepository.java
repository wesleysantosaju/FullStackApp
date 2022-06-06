package com.example.fullstackapp.repository;

import com.example.fullstackapp.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long> {
    //CLASSE REPOSITÓRIO
}
