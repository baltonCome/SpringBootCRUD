/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.savagery.SpringBootCRUD;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Mr. Savagery
 */

@Controller
public class AppController {
    
    @Autowired
    private ContactService service;
    
    @RequestMapping("/")
    public String viewHomePage(Model model){
        
        List<Contact> listContacts = service.listAll();
        model.addAttribute("listContacts", listContacts);
        return "index";
        
    }
    
    @RequestMapping("/add")
    public String newContactForm(Model model){
        
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "add";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("contact") Contact contact){
        
        service.save(contact);
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView editContactForm(@PathVariable(name = "id") int id){
        
        ModelAndView mav = new ModelAndView("edit");
        Contact contact = service.get(id);
        mav.addObject("contact", contact);
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteContactForm(@PathVariable(name = "id") int id){
        
        service.delete(id);
        return "redirect:/";
    }
}
