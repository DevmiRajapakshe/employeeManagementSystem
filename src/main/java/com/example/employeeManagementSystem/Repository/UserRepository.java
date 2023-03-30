package com.example.employeeManagementSystem.Repository;

import com.example.employeeManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //@Query(value = "SELECT * FROM USERS WHERE USER_ID = :userId", nativeQuery = true)
    @Query(value = "SELECT user FROM User user WHERE user.userId = :userId")
    Optional<User> findUserByUserId(@Param("userId") long id);

}

