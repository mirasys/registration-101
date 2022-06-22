package com.firstspringtest.registration.Repository;

import com.firstspringtest.registration.Entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Integer> {

}
