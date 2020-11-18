/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.ivan.uts.services;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uts.ivan.uts.entities.rest.LoginOutput;
import uts.ivan.uts.entities.rest.ProfileInfo;
import uts.ivan.uts.entities.rest.ProfileAddress;
import uts.ivan.uts.entities.rest.ProfileContact;
import uts.ivan.uts.entities.rest.ProfileEducation;
import uts.ivan.uts.entities.rest.ProfileOccupation;

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

        result = restTemplate.getForObject(uri + "profile/basic/{id}" + getUserId(), ProfileInfo.class, param);
        return result;
    }

    public ProfileAddress getProfileAddress(String id) {
        ProfileAddress result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/address/{id}"+ getUserId(), ProfileAddress.class, param);
        return result;
    }

    public ProfileContact getProfileContact(String id) {
        ProfileContact result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/contact/{id}"+ getUserId(), ProfileContact.class, param);
        return result;
    }

    public ProfileOccupation getProfileOccupation(String id) {
        ProfileOccupation result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/currentoccupation/{id}"+ getUserId(), ProfileOccupation.class, param);
        return result;
    }

    public ProfileEducation getProfileEducation(String id) {
        ProfileEducation result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/education/{id}"+ getUserId(), ProfileEducation.class, param);
        return result;
    }
   //=================Get ID FOR SPRING SECURITY====================     
        public String getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput output = (LoginOutput)authentication.getPrincipal();
        return output.getUser().getId();
    }
    //=============================PER SAVE AN DUNIAWI========================================

    public boolean updateProfileBasic(ProfileInfo input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/basic/", input, ProfileInfo.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean updateProfileAddress(ProfileAddress input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/address/", input, ProfileAddress.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean updateProfileContact(ProfileContact input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/contact/", input, ProfileContact.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
    
    public boolean updateProfileOccupation(ProfileOccupation input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/currentoccupation/", input, ProfileOccupation.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }
    
    public boolean updateProfileEducation(ProfileEducation input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/education/", input, ProfileEducation.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

}
