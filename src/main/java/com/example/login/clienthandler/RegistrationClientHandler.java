package com.example.login.clienthandler;

import com.example.login.dto.CustomerRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.login.dto.CustomerResponse;
import com.example.login.dto.LoginRequest;

import java.util.Collections;
import java.util.List;

@Component
@Log4j2
public class RegistrationClientHandler {

    private final WebClient webClient;

    public RegistrationClientHandler(
            @Value("${service-registration.base-url}") String baseUrl,
            WebClient.Builder builder
    ) {
        this.webClient = builder.baseUrl(baseUrl).build();
    }

    public CustomerResponse getUserByEmail(LoginRequest request) {
        return webClient.get()
                .uri("/register/{email}", request.getEmail())
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .block();
    }
    public CustomerResponse deleteCustomerById(Integer id) {
       return webClient.delete()
                .uri("/register/{id}", id)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .block();
    }

    public CustomerResponse updateLogin(Integer id, CustomerRequest request) {
        return webClient.put()
                .uri("/register/{id}", id,request)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .block();
    }


    public List<CustomerResponse> getAllLogin() {
        return webClient.get()
                .uri("/register/all")
                .retrieve()
                .bodyToFlux(CustomerResponse.class)
                .collectList()
                .block();
    }
}


