package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setup() {
        animal = new Animal();
    }

    @Test
    public void testFoodHerb() throws Exception {
        // Тест для "Травоядное"
        List<String> food = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void testFoodPredator() throws Exception {
        // Тест для "Хищник"
        List<String> food = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
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
