package com.firstspringtest.registration.Dto.RequestDTO;

import lombok.*;

@Data @AllArgsConstructor @NoArgsConstructor
public class GetUserDetails {
    private Integer id;
    private String username;
    private String password;
}
