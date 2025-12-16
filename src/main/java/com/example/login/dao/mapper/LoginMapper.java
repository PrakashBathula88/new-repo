package com.example.login.dao.mapper;

import org.springframework.stereotype.Component;

import com.example.login.dto.LoginRequest;
import com.example.login.dto.LoginResponse;
import com.example.login.entity.LoginEntity;

@Component
public class LoginMapper {

    public LoginEntity toLoginRequestMapper(LoginRequest loginRequest) {

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setEmail(loginRequest.getEmail());
        loginEntity.setPassword(loginRequest.getPassword());

        return loginEntity;
    }

    public LoginResponse toLoginResponseMapper(LoginEntity loginEntity) {

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(loginEntity.getId());
        loginResponse.setEmail(loginEntity.getEmail());
        loginResponse.setMessage("success");

        return loginResponse;
    }
}
