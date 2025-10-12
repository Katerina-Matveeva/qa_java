package com.example;
import java.util.List;

public class Cat extends Feline {

    Predator predator;  // Зависимость для еды

    public Cat(Feline feline) {
        // Проверка на ноль
        if (feline == null) {
            throw new RuntimeException("Feline не может быть null");
        }
        this.predator = feline;  // Присваиваем как Predator
    }

    public String getSound() {
        // Звук кошки
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        // Получаем еду от predator
        return predator.eatMeat();
    }
}