package com.example;

import com.example.persistencia.*;

/**
 * Hello world!
 *
 */
public class App 
{
    private static IGBD bd;

    public static void main( String[] args )
    {
        bd = new TextBD();

        Persona p1 = new Persona("0001", "Juan", 7);
        Persona p2 = new Persona("0002", "Pepe", 17);
        Persona p3 = new Persona("0003", "Victor", 31);

        bd.addPersona(p1);
        bd.addPersona(p2);
        bd.addPersona(p3);

        bd.save();
    }
}
