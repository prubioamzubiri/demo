package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LifeActionsTest {
    @Test
    public void testMayorDeEdad() {

        Persona persona = new Persona("a","b",80);
        boolean resultA = persona.isAlive();
        boolean expResultA = true;
        
        LifeActions.morir(persona);
        
        boolean resultD = persona.isAlive();
        boolean expResultD = false;
        
        assertEquals(expResultA, resultA);
        assertEquals(expResultD, resultD);


    }

    @Test
    public void testMorir() {

        Persona persona17 = new Persona("a","b",17);
        Persona persona18 = new Persona("a","b",18);
        Persona persona19 = new Persona("a","b",19);
        
        boolean result17 = LifeActions.mayorDeEdad(persona17);
        boolean result18 = LifeActions.mayorDeEdad(persona18);
        boolean result19 = LifeActions.mayorDeEdad(persona19);
        
        boolean expResult17 = false;
        boolean expResult18 = true;
        boolean expResult19 = true;
        
        assertEquals(result17, expResult17);       
        assertEquals(result18, expResult18);
        assertEquals(result19, expResult19);


    }
}
