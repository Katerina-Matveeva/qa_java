package com.example;

import java.util.List;

public class Lion {

    Feline feline;  // Изменено на Feline

    boolean hasMane;  // Грива

    public Lion(Feline feline, String sex) throws Exception {
        // Проверка null
        if (feline == null) {
            throw new RuntimeException("Feline не может быть null");
        }
        this.feline = feline;
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
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        // Еда от predator
        return feline.eatMeat();
    }
}
