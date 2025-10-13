package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;



public class FelineTest {

    private Feline feline;

    @Before
    public void setup() {
        feline = new Feline();
    }

    @Test
    public void testFamily() {
        // Проверяем семейство Feline
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testDefaultKittens() {
        int count = feline.getKittens();
        assertEquals(1, count);
    }

    @Test
    public void testKittensWithInput() {
        // Проверка для перегруженного (не 1)
        int input = 2;
        int count = feline.getKittens(input);
        assertEquals(input, count);
    }

    @Test
    public void testEatMeat() throws Exception {
        // eatMeat вызывает getFood("Хищник") из Feline
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Мясо", "Кость"), food);
    }

    @Test
    public void testGetFoodForPredator() throws Exception {
        // Для "Хищник" — из Feline
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Мясо", "Кость"), food);
    }

    @Test
    public void testGetFoodForHerbivore() throws Exception {
        // Для "Травоядное" — из Animal
        List<String> food = feline.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    public void testGetFoodException() {
        // Для неизвестного — из Feline/Animal
        try {
            feline.getFood("Неизвестный");
            fail("Должно было бросить");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Неизвестный вид"));
        }
    }
}
