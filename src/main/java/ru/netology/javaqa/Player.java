package ru.netology.javaqa;


public class Player {
    protected int id; // переменная порядкового номера при регистрации
    protected String name; // Имя участника
    protected int strength; // Сила участника

    public Player(int id, String name, int strength) { // конструктор Участника
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}