package com.example.persistencia;

import com.example.dominio.Persona;

public interface IGBD {

    public Persona getPersona(String id);

    public void addPersona(Persona persona);
    
}
