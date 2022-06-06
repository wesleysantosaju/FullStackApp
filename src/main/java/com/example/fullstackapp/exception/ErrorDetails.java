package com.example.fullstackapp.exception;


import java.util.Date;

public class ErrorDetails{
    //CRIANDO ATRIBUTOS
    private Date timestamp;
    private String message;
    private String details;

    //region Bloco - Implementação do Constructor
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
    //endregion

    //region Bloco - Implementação Getters

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
    //endregion


}
