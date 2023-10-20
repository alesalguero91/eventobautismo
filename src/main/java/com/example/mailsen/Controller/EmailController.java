/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mailsen.Controller;

import com.example.mailsen.Dto.EmailValueDto;
import com.example.mailsen.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author salguero
 */
@RestController
public class EmailController {
    @Autowired
    EmailService eService;
    
    @GetMapping("/email/send")
    public ResponseEntity<?> sendEmail(){
        eService.sendEmail();
        return new ResponseEntity("Correo enviado con exito", HttpStatus.OK);
    }
    
    @PostMapping("/email/send-html")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailValueDto dto){
        eService.sendEmailTemplate(dto);
        return new ResponseEntity("Correo con plantilla enviado con exito", HttpStatus.OK);
    }
    
}
