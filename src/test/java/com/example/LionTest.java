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
public class LionTest {

    @Mock
    private Feline felineMock;

    private Lion lion;

    @Before
    public void setupLion() throws Exception {
        lion = new Lion(felineMock, "Самец");
    }

    @Test
    public void maneTest() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void noManeForFemale() throws Exception {
        Lion female = new Lion(felineMock, "Самка");
        assertFalse(female.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = List.of("Мясо", "Кость");  // Из Feline
        when(felineMock.eatMeat()).thenReturn(food);

        List<String> result = lion.getFood();
        assertEquals(food, result);
        verify(felineMock).eatMeat();
    }

    @Test
    public void kittensTest() {
        when(felineMock.getKittens()).thenReturn(2);

        int count = lion.getKittens();
        assertEquals(2, count);
        verify(felineMock).getKittens();
    }

    @Test(expected = Exception.class)
    public void badSexTest() throws Exception {
        new Lion(felineMock, "Неверный");
    }

    @Test(expected = RuntimeException.class)
    public void nullPredatorTest() throws Exception {
        new Lion(null, "Самец");
    }
}
