package com.tekknow.medai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home.htm")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String handleRequest(ModelMap modelMap) {
        System.out.println("HomeController.handleRequest");
        return "home";
    }
}