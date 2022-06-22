package com.firstspringtest.registration.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
@Data @NoArgsConstructor @AllArgsConstructor
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
