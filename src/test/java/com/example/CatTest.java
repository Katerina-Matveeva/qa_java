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
    private Feline felineMock;

    private Cat cat;

    @Before
    public void init()  {
        cat = new Cat(felineMock);
    }

    @Test
    public void testSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = List.of("Мясо", "Кость");  // Из Feline getFood
        when(felineMock.eatMeat()).thenReturn(food);

        List<String> result = cat.getFood();
        assertEquals(food, result);
        verify(felineMock).eatMeat();
    }

    @Test
    public void nullConstructorTest() {
        try {
            new Cat(null);
            fail("Null не должен пройти");
        } catch (RuntimeException e) {
            // OK
        }
    }
}
