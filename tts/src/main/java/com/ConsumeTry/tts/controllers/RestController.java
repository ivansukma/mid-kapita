/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ConsumeTry.tts.controllers;

import com.ConsumeTry.tts.entities.rest.LoginInput;
import com.ConsumeTry.tts.services.RestService;
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
    @Autowired
    RestService service;
    
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
}
