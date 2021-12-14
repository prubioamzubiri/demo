package com.example.persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.management.InvalidAttributeValueException;

import com.example.dominio.Persona;

public class GBD implements IGBD{
    
    private Map<String, Persona> datos;

    public GBD()
    {
        datos = new HashMap<String, Persona>();
    }

    public GBD(File f) throws IOException, InvalidAttributeValueException
    {
        datos = new HashMap<String, Persona>();

        try {

            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String readed;
            Persona persona;

            while((readed = br.readLine()) != null) 
            {
                String[] sep = readed.split(" ");
                
                if(sep.length == 3)
                {
                    persona = new Persona(sep[0], sep[1], Integer.parseInt(sep[2]));

                }
                else if(sep.length ==4)
                {
                    persona = new Persona(sep[0], sep[1], Integer.parseInt(sep[2]), Boolean.parseBoolean(sep[3]));
                }
                else
                {
                    throw new InvalidAttributeValueException("Valor no válido");
                }

                if(!datos.containsKey(sep[0]))
                {
                    datos.put(sep[0], persona);
                }
                
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Persona getPersona(String id) {

        return datos.get(id);

    }

    @Override
    public void addPersona(Persona persona) {
        
        String id = persona.getId();

        if(!datos.containsKey(id))
        {
            datos.put(id, persona);
        }
        
    }

}
