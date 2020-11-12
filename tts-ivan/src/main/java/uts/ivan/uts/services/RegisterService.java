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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uts.ivan.uts.entities.rest.Register;

/**
 *
 * @author ivanr
 */
@Service
public class RegisterService {
     @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;

    public boolean register(Register input) {
        HttpEntity<Register> request = new HttpEntity<>(input, null);
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange("http://116.254.101.228:8080/ma_test/register",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Boolean>() {
        }
        );
        return responseEntity.getBody();
    }
}
