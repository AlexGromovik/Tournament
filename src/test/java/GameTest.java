import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Game;
import ru.netology.javaqa.Player;
import ru.netology.javaqa.exception.NoRegisteredException;

public class GameTest {

    @Test
    public void shouldWinPlayerOne() {
        Game game = new Game();
        Player player1 = new Player(1, "Федор", 360);
        Player player2 = new Player(34, "Вингольд", 300);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Федор", "Вингольд");
        int expected = 1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldWinPlayerTwo() {
        Game game = new Game();
        Player player1 = new Player(34, "Вингольд", 300);
        Player player2 = new Player(1, "Федор", 360);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Вингольд", "Федор");
        int expected = 2;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldBeADraw() {
        Game game = new Game();
        Player player1 = new Player(27, "Venedict", 150);
        Player player2 = new Player(13, "Panfil", 150);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Venedict", "Panfil");
        int expected = 0;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldRegisteredOnlyOnePlayerOne(){
        Game game = new Game();
        Player player1 = new Player(7, "Евгения", 175);
        game.register(player1);

        Assertions.assertThrows(NoRegisteredException.class, () -> {
            game.round("Евгения", "Виктория");
        });
    }

    @Test
    public void shouldRegisteredOnlyOnePlayerTwo(){
        Game game = new Game();
        Player player2 = new Player(7, "Евгения", 175);
        game.register(player2);

        Assertions.assertThrows(NoRegisteredException.class, () -> {
            game.round("Евгения", "Виктория");
        });
    }


    @Test
    public void shouldNoRegisteredPlayers(){
        Game game = new Game();

        Assertions.assertThrows(NoRegisteredException.class, () -> {
            game.round("Jack", "Bill");
        });
    }

}
