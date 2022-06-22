package com.firstspringtest.registration.Service;

import com.firstspringtest.registration.Dto.RequestDTO.GetUserDetails;
import com.firstspringtest.registration.Dto.RequestDTO.RegisterUser;
import com.firstspringtest.registration.Dto.ResponseDTO.GetUserResponse;
import com.firstspringtest.registration.Entity.UserRegistration;

import java.util.List;


public interface UserRegistrationService {
    UserRegistration CreateUser(RegisterUser newUser);
    GetUserResponse GetUser(GetUserDetails getUserDetails);
    List<UserRegistration> GetAllUsers();
    String DeleteUser(Integer id);
    UserRegistration EditUser(RegisterUser getUserDetails);
}
