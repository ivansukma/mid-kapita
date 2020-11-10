/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ConsumeTry.tts.controllers;

import com.ConsumeTry.tts.entities.rest.LoginInput;
import com.ConsumeTry.tts.services.LoginService;
import com.ConsumeTry.tts.entities.rest.ProfileBasic;
import com.ConsumeTry.tts.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author user
 */

@Controller
public class RestController {
    //PROFILE LOGIN TRY
    @Autowired
    LoginService service;
    
    @GetMapping("")
    public String index(Model model){
       model.addAttribute("logininput",new LoginInput());
       return "login";
    }
    @PostMapping("login")
    public String login(LoginInput input){
        System.out.println(input);
        System.out.println(service.login(input));
        return "index";
    }
    //PROFILE GET
    @Autowired
    ProfileService ProfileService;
    
    @GetMapping("profile")
    public String ProfileBasic(Model model) {
        //model.addAttribute("profile", ProfileService.getProfilebasic("USER-00016"));
        System.out.println(ProfileService.getProfilebasic("USER-00016"));
        return "profile_basic";
    }
}
