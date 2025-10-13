package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParametrizedTests {

    private final String animalKind;
    private final List<String> expectedFood;
    private final boolean expectThrow;

    public AnimalParametrizedTests(String animalKind, List<String> expectedFood, boolean expectThrow) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.expectThrow = expectThrow;
    }

    @Parameterized.Parameters(name = "Animal getFood: {0}")
    public static Object[][] params() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Неизвестный", null, true}
        };
    }

    @Test
    public void getFoodParamsTest() throws Exception {
        Animal animal = new Animal();

        if (expectThrow) {
            try {
                animal.getFood(animalKind);
                fail("Throw expected");
            } catch (Exception e) {
                assertTrue(e.getMessage().contains("Неизвестный вид"));
            }
        } else {
            List<String> food = animal.getFood(animalKind);
            assertEquals(expectedFood, food);
        }
    }
}