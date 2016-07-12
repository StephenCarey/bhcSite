package org.bhc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    String landingPage() {
        return "index";
    }

    @RequestMapping(value = "/membership")
    String membershipPage() {
        return "membership";
    }

    @RequestMapping("/infoAndRules")
    String infoAndRules() {
        return "infoAndRules";
    }

    @RequestMapping("/calendar")
    String calendar() {
        return "calendar";
    }

    @RequestMapping("/beginners")
    String beginners() {
        return "beginners";
    }

    // Login form
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}