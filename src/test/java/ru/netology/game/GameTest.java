package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exceptions.NotRegisteredException;
import ru.netology.player.Player;

class GameTest {
    Game game = new Game();
    Player nick = new Player(1, "Nick", 50);
    Player john = new Player(2, "John", 50);
    Player george = new Player(3, "George", 100);
    Player kevin = new Player(4, "Kevin", 150);
    Player bob = new Player(5, "Bob", 200);


    @BeforeEach
    public void setUp() {
        game.register(nick);
        game.register(john);
        game.register(george);
    }


    @Test
    public void firstPlayerWin() {


        int expected = 1;
        int actual = game.round("George", "Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {


        int expected = 2;
        int actual = game.round("Nick", "George");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void draw() {


        int expected = 0;
        int actual = game.round("John", "Nick");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player2IsNotRegistered() {


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("John", "Kevin"));
    }

    @Test
    public void player1IsNotRegistered() {


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Bob", "Nick"));
    }

    @Test
    public void allPlayersIsNotRegistered() {


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Bob", "Kevin"));
    }

}