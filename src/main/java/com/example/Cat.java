package com.example;
import java.util.List;

public class Cat  {

    Predator predator;  // Зависимость для еды

    public Cat(Predator predator) {  // Правка: Predator вместо Feline
        // Проверка на ноль
        if (predator == null) {
            throw new RuntimeException("Predator не может быть null");
        }
        this.predator = predator;
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