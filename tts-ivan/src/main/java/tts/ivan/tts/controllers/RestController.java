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

/**
 *
 * @author ivanr
 */
@Controller
public class RestController {

    @Autowired
    LoginRestService service;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("logininput", new LoginInput());
        return "login";
    }

    @PostMapping("login")
    public String login(LoginInput input) {
        System.out.println(input);
        System.out.println(service.login(input));
        return "redirect:/profile/";
    }

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile/")
    public String profileBasic(Model model) {
        model.addAttribute("profile", profileService.getProfileInfo("USER-00016"));
        System.out.println(profileService.getProfileInfo("USER-00016"));
        return "profile";
    }

    @GetMapping("/address/")
    public String profileAddress(Model model) {
        model.addAttribute("address", profileService.getProfileAddress("USER-00016"));
        System.out.println(profileService.getProfileAddress("USER-00016"));
        return "address";
    }

    @GetMapping("/contact/")
    public String profilecontact(Model model) {
        model.addAttribute("contact", profileService.getProfileContact("USER-00016"));
        System.out.println(profileService.getProfileContact("USER-00016"));
        return "contact";
    }
}
