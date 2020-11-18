/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.ivan.uts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uts.ivan.uts.entities.rest.LoginInput;
import uts.ivan.uts.entities.rest.LoginOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 *
 * @author ivanr
 */
@Service
public class LoginRestService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;

    public LoginOutput login(LoginInput input) {
        HttpEntity<LoginInput> request = new HttpEntity<>(input, null);
        ResponseEntity<LoginOutput> responseEntity = restTemplate.exchange(uri + "login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<LoginOutput>() {
        }
        );
        return responseEntity.getBody();
    }
    
    public String getLoginId(LoginOutput output){
        return output.getUser().getId();
    }

}
