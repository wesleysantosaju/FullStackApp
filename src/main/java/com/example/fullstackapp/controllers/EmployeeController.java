package com.example.fullstackapp.controllers;

import com.example.fullstackapp.model.Employee;
import com.example.fullstackapp.repository.EmployeeRepository;
import com.example.fullstackapp.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    //region Bloco - Injeções de Dependências
    //APLICANDO AS INJEÇÕES DE DEPENDÊNCIA
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    //endregion

    //region Bloco - Requisições HTTP
    //criar método para trazer todos os registros encontrados no DB
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //enregion

}
