package com.firstspringtest.registration.Dto.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterUser {

    private Integer id;
    private String username;
    private String password;
    private String title;
    private String firstName;
    private String lastName;
    private String sex;
    private Long bvn;
    private String postalAddress;
    private String homeAddress;
    private String emailAddress;
    private Long mobileNumber;
}