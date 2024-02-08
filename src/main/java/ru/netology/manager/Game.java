package ru.netology.manager;

import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> registeredPlayers = new ArrayList<>();

    public List<Player> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public Player isRegistered(String name) {
        for (Player player : registeredPlayers) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player_1 = isRegistered(playerName1);
        Player player_2 = isRegistered(playerName2);
        if (player_1 == null) {
            throw new NotRegisteredException(
                    "Player " + playerName1 + " is not registered."
            );
        }
        if (player_2 == null) {
            throw new NotRegisteredException(
                    "Player " + playerName2 + " is not registered."
            );
        }
        if (player_1.getStrength() > player_2.getStrength()) {
            return 1;
        } else if (player_1.getStrength() < player_2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
