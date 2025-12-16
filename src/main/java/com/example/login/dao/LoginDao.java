package com.example.login.dao;

import com.example.login.dao.mapper.LoginMapper;
import com.example.login.dto.LoginRequest;
import com.example.login.dto.LoginResponse;
import com.example.login.entity.LoginEntity;
import com.example.login.repository.LoginRepository;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginDao {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginMapper loginMapper;

    public LoginResponse saveLogin(LoginRequest request) {
        log.info("LoginDao before saveLogin");
        LoginEntity toSave = loginMapper.toLoginRequestMapper(request);
        log.info("LoginDao converting mapper and  saveLogin");
        LoginEntity savedEntity = loginRepository.save(toSave);
        log.info("LoginDao after saveLogin and saving in d.b");
        return loginMapper.toLoginResponseMapper(savedEntity);

    }

//    public LoginResponse findByEmail(String email) {
//
//        LoginEntity loginEntity = loginRepository.findByEmail(email);
//
//        if (loginEntity == null) {
//            return null;
//        }
//
//        return loginMapper.toLoginResponseMapper(loginEntity);
//    }
//    public LoginResponse updateLogin(Integer id, LoginRequest request) {
//    	LoginEntity fetching=loginRepository.findById(id)
//    			.orElseThrow(() -> new RuntimeException("Login entry not found"));
//
//    	fetching.setEmail(request.getEmail());
//    	fetching.setPassword(request.getPassword());
//
//    	LoginEntity updated = loginRepository.save(fetching);
//    	return loginMapper.toLoginResponseMapper(updated);
//
//    }
//    public LoginResponse deleteLoginById(Integer id) {
//    	LoginEntity deleting = loginRepository.findById(id)
//    			.orElseThrow(() -> new RuntimeException("NOt foud id"+ id));
//    	loginRepository.delete(deleting);
//    	return loginMapper.toLoginResponseMapper(deleting);
//
//    }
//    public LoginResponse getloginById(Integer id) {
//    	LoginEntity getting = loginRepository.findById(id)
//    			.orElseThrow(() -> new RuntimeException("NOt foud id"+ id));
//    	return loginMapper.toLoginResponseMapper(getting);
//    }
//    public List<LoginResponse> getAllLogin(){
//    	List<LoginEntity> getAll = loginRepository.findAll();
//    	List<LoginResponse> push = new ArrayList<>();
//
//    	for(LoginEntity entity : getAll) {
//    		LoginResponse res =loginMapper.toLoginResponseMapper(entity);
//    		push.add(res);
//    	}
//    	return push;
//    }
}
