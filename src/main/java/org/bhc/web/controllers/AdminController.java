package org.bhc.web.controllers;

import org.bhc.persistance.models.Walk;
import org.bhc.persistance.repository.WalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by careys on 11/07/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private WalkRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    String landingPage() {
        return "admin/index";
    }

    @RequestMapping("/addwalk")
    String addWalkPage(Model model)
    {
        Walk walk = new Walk();

        model.addAttribute("walk",walk);
        return "admin/addwalk";
    }

    @RequestMapping(value = "/processWalk", method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="walk") Walk walk) {

        repository.save(walk);

        return "admin/index";
    }
}
