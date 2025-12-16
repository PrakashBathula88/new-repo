package com.example.login.services.serviceimpl;

import com.example.login.clienthandler.RegistrationClientHandler;

import com.example.login.dao.LoginDao;
import com.example.login.dto.CustomerRequest;
import com.example.login.dto.CustomerResponse;
import com.example.login.dto.LoginRequest;
import com.example.login.dto.LoginResponse;
import com.example.login.services.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    RegistrationClientHandler registrationClientHandler;

    @Autowired
    LoginDao loginDao;

    @Override
    public LoginResponse login(LoginRequest request) {
        log.info("Login Request: {}", request);
        // call the registration service
        CustomerResponse response = registrationClientHandler.getUserByEmail(request);

        LoginResponse login = new LoginResponse();
        log.info("Login Response before Setting: {}", login);
        login.setEmail(response.getEmail());
        login.setMessage("Login success");
        log.info("Login Response after Setting: {}", login);
        // save login in DB
        loginDao.saveLogin(request);
        log.info("Login Response: {}", login);

        return login;
    }

	@Override
	public CustomerResponse updateLogin(Integer id, CustomerRequest request) {

		return registrationClientHandler.updateLogin(id,request);
	}

    @Override
    public CustomerResponse deleteLoginById(Integer id) {
		return registrationClientHandler.deleteCustomerById(id);
	}

	@Override
	public List<CustomerResponse> getAllLoginById() {

		return registrationClientHandler.getAllLogin();
	}
    
}
