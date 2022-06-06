package com.example.fullstackapp.controllers;

import com.example.fullstackapp.exception.ResourceNotFoundException;
import com.example.fullstackapp.model.Employee;
import com.example.fullstackapp.repository.EmployeeRepository;
import com.example.fullstackapp.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    //CRIAR MÉTODO QUE TRAZ TODOS OS REGISTROS DE USUÁRIO REGISTRADOS NO DB
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //MÉTODO PARA TRAZER UM ÚNICO REGISTRO SE ASSIM FOR SOLICITADO
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeId(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Colaborador não encontrado: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }
    //MÉTODO PARA CRIAR UM REGISTRO NO DB
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeRepository.save(employee);
    }
    //MÉTODO PARA ATUALIZAR REGISTROS
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Colaborador não encontrado: " + employeeId));

            //MANIPULANDO VALORES A PARTIR DA CONSTRUÇÃO DO MODEL
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updateEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updateEmployee);
    }
    //endregion
}
