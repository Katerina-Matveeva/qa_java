package com.example;

import java.util.List;

public class Lion {

    Predator predator;  // Зависимость
    boolean hasMane;  // Грива

    public Lion(Predator predator, String sex) throws Exception {
        // Проверка null
        if (predator == null) {
            throw new RuntimeException("Predator не может быть null");
        }
        this.predator = predator;
        // Устанавливаем гриву по полу
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return predator.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        // Еда от predator
        return predator.eatMeat();
    }
}
