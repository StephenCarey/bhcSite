package org.bhc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by careys on 11/07/2016.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping(method = RequestMethod.GET)
    String landingPage() {
        return "admin/index";
    }

    @RequestMapping("/test")
    String testPage() {
        return "admin/test";
    }
}
