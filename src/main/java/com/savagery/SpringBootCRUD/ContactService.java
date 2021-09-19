/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.savagery.SpringBootCRUD;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mr. Savagery
 */

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository repository;
    
    public List <Contact> listAll(){
        
        return repository.findAll();
    }
    
    public void save(Contact contact){
        
        repository.save(contact);
    }
    
    public Contact get(int id){
        
        return repository.findById(id).get();
    }
    
    public void delete (int id){
        
        repository.deleteById(id);
    }
}
