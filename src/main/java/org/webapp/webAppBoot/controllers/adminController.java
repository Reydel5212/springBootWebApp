package org.webapp.webAppBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.webapp.webAppBoot.models.person;
import org.webapp.webAppBoot.services.peopleService;

@Controller
@RequestMapping("/admin")
public class adminController {

    private final peopleService peopleService;

    @Autowired
    public adminController(peopleService peopleService){
        this.peopleService = peopleService;
    }

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") person person){
        model.addAttribute("people", peopleService.findAll());

        return "admin/adminPage";
    }

    @PostMapping("/add")
    public String makeAdmin(@ModelAttribute("person") person person){
        System.out.println(person.getId());

        return "redirect:/people";
    }
}
