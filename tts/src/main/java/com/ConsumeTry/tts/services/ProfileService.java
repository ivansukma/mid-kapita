/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ConsumeTry.tts.services;

import com.ConsumeTry.tts.entities.rest.ProfileBasic;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ivanr
 */
@Service
public class ProfileService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;
    
    public ProfileBasic getProfibasic(String id){
        
        Person result;
        Map<String, String> param = new HashMap<>();
        param.put("id", id);
        result = restTemplate.getForObject(uri+"/{id}", Person.class, param);
        return result;
    }
}
