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
    public void getFoodReturnsTest() throws Exception {
        // Только результат (исправленно)
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(food);
        List<String> result = lion.getFood();
        assertEquals(food, result);
    }
    @Test
    public void getFoodCallsTest() throws Exception {
        // Только вызов (исправленно)
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(food);
        lion.getFood();
        verify(felineMock).eatMeat();
    }

    @Test
    public void kittensReturnsTest() {
        // Только результат с реальным значением
        when(felineMock.getKittens()).thenReturn(1);
        int count = lion.getKittens();
        assertEquals(1, count);  // Одна проверка
    }
    @Test
    public void kittensCallsTest() {
        // Только вызов с реальным значением
        when(felineMock.getKittens()).thenReturn(1);
        lion.getKittens();
        verify(felineMock).getKittens();  // Одна проверка
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
