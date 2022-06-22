package com.firstspringtest.registration.Implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.firstspringtest.registration.Dto.RequestDTO.GetUserDetails;
import com.firstspringtest.registration.Dto.RequestDTO.RegisterUser;
import com.firstspringtest.registration.Dto.ResponseDTO.GetUserResponse;
import com.firstspringtest.registration.Entity.UserRegistration;
import com.firstspringtest.registration.Repository.UserRegistrationRepository;
import com.firstspringtest.registration.Service.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserRegistrationServiceImplementation implements UserRegistrationService {
    private final ObjectMapper objectMapper;
    private final UserRegistrationRepository userRegistrationRepository;


    @Override
    public UserRegistration CreateUser(RegisterUser newUser) {
        UserRegistration user = objectMapper.convertValue(newUser,UserRegistration.class);
        userRegistrationRepository.save(user);
        return user;
    }

    @Override
    public GetUserResponse GetUser(GetUserDetails getUserDetails) {
        UserRegistration user = objectMapper.convertValue(getUserDetails,UserRegistration.class);
        log.info("{}",user);
        GetUserResponse responseUser = new GetUserResponse();
        UserRegistration db = userRegistrationRepository.findById(user.getId()).get();
        if(db.getId() != getUserDetails.getId() && db.getUsername() != getUserDetails.getUsername()
                && db.getPassword() != getUserDetails.getPassword()){
            return null;
        }else{
            responseUser.setBvn(db.getBvn());
            responseUser.setFirstName(db.getFirstName());
            responseUser.setLastName(db.getLastName());
            responseUser.setTitle(db.getTitle());
            responseUser.setSex(db.getSex());
            responseUser.setEmailAddress(db.getEmailAddress());
            responseUser.setHomeAddress(db.getHomeAddress());
            responseUser.setMobileNumber(db.getMobileNumber());

        }
        log.info("{}",responseUser);
        return responseUser;
    }

    @Override
    public List<UserRegistration> GetAllUsers()
    {
        return userRegistrationRepository.findAll();
    }

    @Override
    public String DeleteUser(Integer Id) {
        if(userRegistrationRepository.findById(Id).isPresent()){
            userRegistrationRepository.deleteById(Id);
            return String.format("User with ID: {} has been successfully deleted", Id);
        }else{
            return "Record not found";
        }
    }

    @Override
    public UserRegistration EditUser(RegisterUser getUserDetails) {
        UserRegistration userRegistration = userRegistrationRepository.findById(getUserDetails.getId()).get();
        if(!userRegistrationRepository.findById(getUserDetails.getId()).isPresent()){
            return null;

        }else{
            userRegistration.setUsername(getUserDetails.getUsername());
            userRegistration.setPassword(getUserDetails.getPassword());
            userRegistration.setSex(getUserDetails.getSex());
            userRegistration.setTitle(getUserDetails.getTitle());
            userRegistration.setMobileNumber(getUserDetails.getMobileNumber());
            userRegistration.setHomeAddress(getUserDetails.getHomeAddress());
            userRegistration.setEmailAddress(getUserDetails.getEmailAddress());
            userRegistration.setId(getUserDetails.getId());
            userRegistration.setPostalAddress(getUserDetails.getPostalAddress());
            userRegistration.setBvn(getUserDetails.getBvn());
            userRegistration.setFirstName(getUserDetails.getFirstName());
            userRegistration.setLastName(getUserDetails.getLastName());

        }
        userRegistrationRepository.save(userRegistration);
        return userRegistration;
    }
}
