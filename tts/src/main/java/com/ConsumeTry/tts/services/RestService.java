/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ConsumeTry.tts.services;

import com.ConsumeTry.tts.entities.rest.LoginInput;
import com.ConsumeTry.tts.entities.rest.LoginOutput;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ivanr
 */
@Service
public class RestService {
 
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${api.uri}")
    private String uri;
    
    public LoginOutput login(LoginInput input){
      HttpEntity<LoginInput> request = new HttpEntity<>(input, null);
      ResponseEntity<LoginOutput> responseEntity = restTemplate.exchange(uri +"/login",
              HttpMethod.POST,
              request,
              new ParameterizedTypeReference<LoginOutput>(){
              }
              );
      return responseEntity.getBody();
    }

}
