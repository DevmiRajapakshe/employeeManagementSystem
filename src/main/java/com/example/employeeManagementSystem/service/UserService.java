package com.example.employeeManagementSystem.service;

import com.example.employeeManagementSystem.dto.UserDto;
import com.example.employeeManagementSystem.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    List<UserDto> getUserList();

    UserDto getUser(Long userId);
}
