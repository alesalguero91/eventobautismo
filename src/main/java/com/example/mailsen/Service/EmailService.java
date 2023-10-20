/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mailsen.Service;

import com.example.mailsen.Dto.EmailValueDto;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author salguero
 */
@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;
    
    @Autowired
    TemplateEngine templateEngine;
    
    @Value("${mail.urlFront}")
    private String urlFront;
    
    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("salguero.soporte@gmail.com");
        message.setTo("nestorale.salguero91@outlook.es");
        message.setSubject("PruebaEnvio email simple");
        message.setText("El contenido del email");
        
        javaMailSender.send(message);
    }
    
    public void sendEmailTemplate(EmailValueDto dto){
        MimeMessage message = javaMailSender.createMimeMessage();
        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", dto.getUserName());
            model.put("url", "localhost:4200"+ dto.getJwt());
            context.setVariables(model);
            String htmlText = templateEngine.process("emailTemplate", context);
            helper.setFrom(dto.getMailFrom());
            helper.setTo(dto.getMailTo());
            helper.setSubject(dto.getSubject());
            helper.setText(htmlText, true);
            
            javaMailSender.send(message);
                   
        } catch(MessagingException e){
            e.printStackTrace();
        }
    }
    
}
