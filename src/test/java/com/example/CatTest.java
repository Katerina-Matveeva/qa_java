package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Predator predatorMock ;

    private Cat cat;

    @Before
    public void init()  {
        cat = new Cat(predatorMock);
    }

    @Test
    public void testSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodReturnsTest() throws Exception {
        // Проверка результата
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(food);
        List<String> result = cat.getFood();
        assertEquals(food, result);
    }
    @Test
    public void getFoodCallsTest() throws Exception {
        // Проверка вызова
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(food);
        cat.getFood();
        verify(predatorMock).eatMeat();
    }


    @Test
    public void nullConstructorTest() {
        try {
            new Cat(null);
            fail("Null не должен пройти");
        } catch (RuntimeException e) {
            assertTrue(e.getMessage().contains("Predator"));
        }
    }
}
