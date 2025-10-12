package com.example;

import java.util.Arrays;
import java.util.List;

public class Feline extends Animal implements Predator {

    @Override
    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }

    // getFood для кошачьих
    @Override
    public List<String> getFood(String animalType) throws Exception {
        if ("Хищник".equals(animalType)) {
            return Arrays.asList("Мясо", "Кость");
        } else {
            return super.getFood(animalType);  // Наследуем от Animal
        }
    }
}
