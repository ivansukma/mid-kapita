/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tts.ivan.tts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tts.ivan.tts.services.LoginRestService;
import tts.ivan.tts.entities.rest.LoginInput;
import tts.ivan.tts.services.ProfileService;
import tts.ivan.tts.entities.rest.ProfileInfo;
import tts.ivan.tts.entities.rest.ProfileAddress;
import tts.ivan.tts.entities.rest.ProfileContact;
import tts.ivan.tts.entities.rest.ProfileOccupation;
import tts.ivan.tts.entities.rest.ProfileEducation;
import tts.ivan.tts.services.RegisterService;
import tts.ivan.tts.entities.rest.Register;

/**
 *
 * @author ivanr
 */
@Controller
public class RestController {

    @Autowired
    LoginRestService service;
    
    String id;
    
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("logininput", new LoginInput());
        return "login";
    }

    @PostMapping("login")
    public String login(LoginInput input) {
        System.out.println(input);
        System.out.println(service.login(input));
        id= service.getLoginId(service.login(input));
        System.out.println(id);
        return "redirect:/profile/";
    }

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile/")
    public String profileBasic(Model model) {
        model.addAttribute("profile", profileService.getProfileInfo(id));
        System.out.println(profileService.getProfileInfo(id));
        return "profile_basic";
    }

    @GetMapping("/address/")
    public String profileAddress(Model model) {
        model.addAttribute("address", profileService.getProfileAddress(id));
        System.out.println(profileService.getProfileAddress(id));
        return "profile_address";
    }

    @GetMapping("/contact/")
    public String profilecontact(Model model) {
        model.addAttribute("contact", profileService.getProfileContact(id));
        System.out.println(profileService.getProfileContact(id));
        return "profile_contact";
    }

    @GetMapping("/occupation/")
    public String profileOccupation(Model model) {
        model.addAttribute("occupation", profileService.getProfileOccupation(id));
        System.out.println(profileService.getProfileOccupation(id));
        return "profile_occupation";
    }

    @GetMapping("/education/")
    public String profileEducation(Model model) {
        model.addAttribute("education", profileService.getProfileEducation(id));
        System.out.println(profileService.getProfileEducation(id));
        return "profile_education";
    }
    //=================Per Save An duniawi==================

    @PostMapping("/saveinfo")
    public String save(ProfileInfo input) {
        profileService.updateProfileBasic(input);
        return "redirect:/profile/";
    }

    @PostMapping("/saveaddress")
    public String save(ProfileAddress input) {
        profileService.updateProfileAddress(input);
        return "redirect:/address/";
    }

    @PostMapping("/savecontact")
    public String save(ProfileContact input) {
        profileService.updateProfileContact(input);
        return "redirect:/contact/";
    }

    @PostMapping("/saveoccupation")
    public String save(ProfileOccupation input) {
        profileService.updateProfileOccupation(input);
        return "redirect:/occupation/";
    }

    @PostMapping("/saveeducation")
    public String save(ProfileEducation input) {
        profileService.updateProfileEducation(input);
        return "redirect:/education/";
    }
//======================================Register===========================================
    @Autowired
    RegisterService RegisterService;

    @GetMapping("/register")
    public String registerindex(Model model) {
        model.addAttribute("register", new Register());
        return "register";
    }

    @PostMapping("/register")
    public String register(Register input) {
        System.out.println(input);
        System.out.println(RegisterService.register(input));
        return "redirect:/profile/";
    }
}
