package com.example.employeeManagementSystem.service.impl;

import com.example.employeeManagementSystem.Exception.UserIdNotAvailableException;
import com.example.employeeManagementSystem.Repository.UserRepository;
import com.example.employeeManagementSystem.dto.UserDto;
import com.example.employeeManagementSystem.entity.User;
import com.example.employeeManagementSystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user = userRepository.save(user);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public List<UserDto> getUserList() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserDto userDto = new UserDto();
                    BeanUtils.copyProperties(user, userDto);
                    return userDto;
                }).collect(Collectors.toList());
    }

    @Override
    public UserDto getUser(Long userId) {
        try {
            return userRepository.findUserByUserId(userId)
                    .map(user -> {
                        UserDto userDto = new UserDto();
                        BeanUtils.copyProperties(user, userDto);
                        return userDto;
                    })
                    .orElseThrow(()->new UserIdNotAvailableException("User id" + userId + "not available"));
        } catch(Exception e) {
            return null;
        }
    }
}
