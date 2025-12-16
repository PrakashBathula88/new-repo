package com.example.login.controller;

import com.example.login.dto.CustomerRequest;
import com.example.login.dto.CustomerResponse;
import com.example.login.dto.LoginRequest;
import com.example.login.dto.LoginResponse;
import com.example.login.services.LoginService;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        log.info("login");
        return loginService.login(request);
    }
    @DeleteMapping("/delete/{id}")
    public CustomerResponse deleteLoginById(@PathVariable Integer id){
        return loginService.deleteLoginById(id);
    }
    @GetMapping("/all")
    public List<CustomerResponse> getAll(){
        return loginService.getAllLoginById();
    }
    @PutMapping("/{id}")
    public CustomerResponse updateService(@PathVariable Integer id, @RequestBody CustomerRequest request){
        return loginService.updateLogin(id,request);
    }
}

//    @PutMapping("/update/{id}")
//    public LoginResponse updateLogin(@PathVariable Integer id , @RequestBody LoginRequest request) {
//    	return loginService.updateLogin(id, request);
//    }
//   @DeleteMapping("/delete/{id}")
//   public LoginResponse deleteLoginById(@PathVariable Integer id) {
//    	return loginService.deleteLoginById(id);
//    }
//   @GetMapping("/get/{id}")
//    public LoginResponse getloginById(@PathVariable Integer id) {
//    	return loginService.getloginById(id);
//    }
//   @GetMapping("/All")
//   public List<LoginResponse> getAllLoginById(){
//    	return loginService.getAllLoginById();
//    }
//}
