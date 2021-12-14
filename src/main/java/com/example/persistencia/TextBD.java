package com.example.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.management.InvalidAttributeValueException;

import com.example.dominio.Persona;

public class TextBD implements IGBD{
    
    private Map<String, Persona> datos;

    public TextBD()
    {
        datos = new HashMap<String, Persona>();
    }

    public TextBD(File f) throws IOException, InvalidAttributeValueException
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

        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public Persona getPersona(String id) {

        Persona to_return = null;

        if(datos.containsKey(id))
        {
            to_return = datos.get(id);
        }
        return to_return;

    }

    @Override
    public void addPersona(Persona persona) {
        
        String id = persona.getId();

        if(!datos.containsKey(id))
        {
            datos.put(id, persona);
        }
        
    }

    public void save()
    {

        File file = new File("datos.txt");
        Persona persona;

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            Set<String> keys = datos.keySet();

            for (String key : keys) {
                
                persona = datos.get(key);

                String line = key + " " + persona.getName() + " " + persona.getAge() + " " + persona.isAlive();

                bw.write(line);
                bw.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
