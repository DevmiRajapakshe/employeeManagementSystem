package com.example.employeeManagementSystem.Exception;

public class UserIdNotAvailableException extends RuntimeException{
    public UserIdNotAvailableException(String message) {
        super(message);
    }
}
