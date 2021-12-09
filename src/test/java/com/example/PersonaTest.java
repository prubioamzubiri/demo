package com.example;

import static org.junit.Assert.assertEquals;

import java.util.Random;

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
        
        int expResultA = initAge++;
        int resultA = instance.getAge();        
        
        assertEquals(expResultD, resultD);
        assertEquals(expResultA, resultA);
    }

}
