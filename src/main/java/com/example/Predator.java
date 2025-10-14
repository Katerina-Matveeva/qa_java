package com.example;

import java.util.List;

public interface Predator {
    // Ест мясо (для хищников)
    List<String> eatMeat() throws Exception;

    // Семейство
    String getFamily();

    // Количество котят
    int getKittens();

    List<String> getFood(String animalType) throws Exception;
}
