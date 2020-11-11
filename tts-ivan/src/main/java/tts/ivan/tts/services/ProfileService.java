/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.ivan.tts.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tts.ivan.tts.entities.rest.ProfileInfo;

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
    
    
    public ProfileInfo getProfileInfo(String id){
        ProfileInfo result;
        Map<String, String> param = new HashMap<>();
        
        param.put("id", id);
        
        result = restTemplate.getForObject(uri + "profile/basic/{id}", ProfileInfo.class, param);
        return result;
    }
}
