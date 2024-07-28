package ru.netology.javaqa;

import ru.netology.javaqa.exception.NoRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<Player>(); // Список зарегистрированных участников

    public void register(Player player) { // Метод регистрации участника
        players.add(player);
    }

    public int round(String playerName1, String playerName2) { // Метод процедуры проведения этапа между двух участников
        Player player1 = null; // присвоение пустой значения
        Player player2 = null;

        for (Player player : players) { // осуществляем сверку с элементами по всему списку
            if (player.getName().equals(playerName1)) { // поиск совпадений в списке по имени первого участника
                player1 = player;
            }

            if (player.getName().equals(playerName2)) { // поиск совпадений в списке по имени первого участника
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NoRegisteredException( // Прогоняем через исключение если не зарегистрирован
                    "Player " + playerName1 + " isn't registered"
            );
        }

        if (player2 == null) {
            throw new NoRegisteredException( // Прогоняем через исключение если не зарегистрирован
                    "Player " + playerName2 + " isn't registered"
            );
        }
        // сравниваем участников по параметру силы
        if (player1.getStrength() > player2.getStrength()) {
            return 1; // победа первого участника
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2; // победа второго участника
        }
        return 0; // ничья
    }
}
