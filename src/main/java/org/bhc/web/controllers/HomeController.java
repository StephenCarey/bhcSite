package org.bhc.web.controllers;

import org.bhc.persistance.repository.WalkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private WalkRepository repository;

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
    String calendar(Model model) {
        model.addAttribute("walks", repository.findAll());
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