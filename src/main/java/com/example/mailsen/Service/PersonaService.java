/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mailsen.Service;

import com.example.mailsen.Entity.Persona;
import com.example.mailsen.Interface.IPersonaService;
import com.example.mailsen.Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author salguero
 */
@Service
public class PersonaService implements IPersonaService{
    @Autowired PersonaRepository personaRepo;

    @Override
    public List<Persona> verPersonas() {
        List<Persona>per= personaRepo.findAll();
        return per;
    }

    @Override
    public void crearPersona(Persona per) {
        personaRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        Persona per = personaRepo.findById(id).orElse(null);
        return per;
    }
    
}
