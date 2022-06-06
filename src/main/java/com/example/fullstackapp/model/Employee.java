package com.example.fullstackapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collation = "Employee")
public class Employee {
    //CRIANDO PROPRIEDADE STATIC FINAL PARA SER A SEQUÊNCIA DE USUÁRIOS
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    //region Bloco - Atributos da Classe
    @Id
    private long id;
    //INDICANDO NOME E SOBRENOME
    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String firstName;
    private String lastName;

    @NotBlank
    @Size(max=100)
    @Indexed(unique = true)
    private String emailId;

    //endregion

    //region Bloco - Contrutor Padrão
    public Employee(){    }
    //endregion

    //region Bloco - Construtor

    public Employee(long id, String firstName, String lastName, String emailId) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    //endregion

    //region Bloco - Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    //endregion

    //region Bloco - toString()
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
    //endregion
}
