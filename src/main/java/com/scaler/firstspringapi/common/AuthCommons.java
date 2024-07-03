package com.scaler.firstspringapi.common;

import com.scaler.firstspringapi.dtos.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@AllArgsConstructor
public class AuthCommons {

    private RestTemplate restTemplate;


    public UserDto validateToken(String tokenValue){
        //call user service to authenticate the token
        ResponseEntity<UserDto> responseEntity =
        restTemplate.getForEntity("http://localhost:4141/users/validate/"+tokenValue,UserDto.class);
        if(responseEntity.getBody() == null) return null;

        return responseEntity.getBody();

    }
}
