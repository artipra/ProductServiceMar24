package com.scaler.firstspringapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private String name;
    private String email;
    private List<Roles> roles;
}
