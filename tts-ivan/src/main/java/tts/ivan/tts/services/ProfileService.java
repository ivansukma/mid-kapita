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
import tts.ivan.tts.entities.rest.ProfileAddress;
import tts.ivan.tts.entities.rest.ProfileContact;

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

    public ProfileInfo getProfileInfo(String id) {
        ProfileInfo result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/basic/{id}", ProfileInfo.class, param);
        return result;
    }

    public ProfileAddress getProfileAddress(String id) {
        ProfileAddress result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/address/{id}", ProfileAddress.class, param);
        return result;
    }
    
    public ProfileContact getProfileContact(String id) {
        ProfileContact result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/contact/{id}", ProfileContact.class, param);
        return result;
    }
}
