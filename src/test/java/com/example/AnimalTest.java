package com.example;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setup() {
        animal = new Animal();
    }

    @Test
    public void testFoodThrow() {
        // Тест для throw
        try {
            animal.getFood("Неизвестный");
            fail("Должно бросить");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Неизвестный вид"));
        }
    }

    @Test
    public void testFamily() {
        // Тест для getFamily
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}
