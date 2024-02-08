package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;
import ru.netology.manager.Game;

import java.util.ArrayList;
import java.util.List;

public class GameTest {
    Player player1 = new Player(1, "Alex1", 8);
    Player player2 = new Player(2, "NedStreX", 16);
    Player player3 = new Player(3, "NyanCat", 10);
    Player player4 = new Player(4, "E2E4", 3);
    Player player5 = new Player(5, "KiberTron", 9);
    Player player6 = new Player(5, "Cr1stal", 8);

    @Test
    public void shouldRegisteredPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player6);
        game.register(player5);

        List<Player> expected = new ArrayList<>();
        expected.add(player1);
        expected.add(player6);
        expected.add(player5);

        List<Player> actual = game.getRegisteredPlayers();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNotRegisteredException() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, ()-> game.round(player1.getName(), player2.getName()));
        Assertions.assertThrows(NotRegisteredException.class, ()-> game.round(player3.getName(), player4.getName()));
    }

    @Test
    public void shouldRoundWhenPlayer1IsWin() {
        Game game = new Game();
        game.register(player2);
        game.register(player1);

       int expected = 1;
       int actual = game.round(player2.getName(), player1.getName());

       Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenPlayer2IsWin() {
        Game game = new Game();
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round(player4.getName(), player5.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundWhenGameDraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player6);

        int expected = 0;
        int actual = game.round(player1.getName(), player6.getName());

        Assertions.assertEquals(expected, actual);
    }


}
