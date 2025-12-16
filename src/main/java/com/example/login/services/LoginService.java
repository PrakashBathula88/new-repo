package com.example.login.services;

import java.util.List;

import com.example.login.dto.CustomerRequest;
import com.example.login.dto.CustomerResponse;
import com.example.login.dto.LoginRequest;
import com.example.login.dto.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest request);

    CustomerResponse deleteLoginById(Integer id);
    CustomerResponse updateLogin(Integer id , CustomerRequest request);
    List<CustomerResponse> getAllLoginById();
}
