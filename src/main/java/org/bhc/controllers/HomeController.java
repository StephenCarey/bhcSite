package org.bhc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/membership")
    String membership() {
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

}