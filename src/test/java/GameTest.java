import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
    }

    @Test
    public void testPlayerNotRegistered() {
        Player player1 = new Player("Player1", 5);
        Player player2 = new Player("Player2", 6);

        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> game.round("Player1", "Player3"));
        assertThrows(NotRegisteredException.class, () -> game.round("Player3", "Player2"));
    }

    @Test
    public void testPlayer1Wins() throws NotRegisteredException {
        Player player1 = new Player("Player1", 7);
        Player player2 = new Player("Player2", 5);

        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Player1", "Player2"));
    }

    @Test
    public void testPlayer2Wins() throws NotRegisteredException {
        Player player1 = new Player("Player1", 3);
        Player player2 = new Player("Player2", 5);

        game.register(player1);
        game.register(player2);

        assertEquals(2, game.round("Player1", "Player2"));
    }

    @Test
    public void testDraw() throws NotRegisteredException {
        Player player1 = new Player("Player1", 5);
        Player player2 = new Player("Player2", 5);

        game.register(player1);
        game.register(player2);

        assertEquals(0, game.round("Player1", "Player2"));
    }
}
