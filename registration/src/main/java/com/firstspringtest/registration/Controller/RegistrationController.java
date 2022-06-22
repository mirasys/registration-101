package com.firstspringtest.registration.Controller;

import com.firstspringtest.registration.Dto.RequestDTO.GetUserDetails;
import com.firstspringtest.registration.Dto.RequestDTO.RegisterUser;
import com.firstspringtest.registration.Dto.ResponseDTO.GetUserResponse;
import com.firstspringtest.registration.Entity.UserRegistration;
import com.firstspringtest.registration.Implementation.UserRegistrationServiceImplementation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private UserRegistrationServiceImplementation userService;

    @Autowired
    public RegistrationController(UserRegistrationServiceImplementation userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistration> CreateUser(@RequestBody RegisterUser newUser) {
        UserRegistration user = userService.CreateUser(newUser);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register/create").toUriString());
        return ResponseEntity.created(uri).body(user);
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetUserResponse> GetAUser(@RequestBody GetUserDetails getUserDetails){
        return ResponseEntity.ok().body(userService.GetUser(getUserDetails));
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserRegistration>> GetAllUsers(){
        return ResponseEntity.ok().body(userService.GetAllUsers());
    }
    @RequestMapping(value = "/delete/", method = RequestMethod.DELETE)
    public ResponseEntity<String> DeleteUser(@RequestParam("Id") Integer Id){
        return ResponseEntity.ok().body(userService.DeleteUser(Id));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistration> EditUser(@RequestBody RegisterUser getUserDetails){
        return ResponseEntity.ok().body(userService.EditUser(getUserDetails));
    }
}
