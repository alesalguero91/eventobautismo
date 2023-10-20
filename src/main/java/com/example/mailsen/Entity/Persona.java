/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mailsen.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author salguero
 */

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String apellido;
    private boolean contesto;
    private boolean asistira;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, boolean contesto, boolean asistira) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contesto = contesto;
        this.asistira = asistira;
    }
    
}
