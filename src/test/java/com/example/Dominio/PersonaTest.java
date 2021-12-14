package com.example.Dominio;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class PersonaTest {

    @org.junit.Test
    public void testHBirthday() {
        System.out.println("hBirthday");
        
        Random random = new Random();
        int initAge = random.nextInt();
        
        Persona instance = new Persona("a", "b", initAge, false);
        instance.hBirthday();
        int expResultD = initAge;
        int resultD = instance.getAge();

        instance.setAlive(true);
        instance.hBirthday();
        
        int expResultA = initAge + 1;
        int resultA = instance.getAge();        
        
        assertEquals(expResultD, resultD);
        assertEquals(expResultA, resultA);
    }

    @Test
    public void testGetAge() {
        
        assertEquals(true, true);

    }

    @Test
    public void testGetId() {
        
        assertEquals(true, false);
    }

    @Test
    public void testGetName() {
        
        assertEquals(true, false);
    }

}
