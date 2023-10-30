import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
    private List<Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    private Optional<Player> findPlayerByName(String name) {
        return registeredPlayers.stream().filter(player -> player.getName().equals(name)).findFirst();
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findPlayerByName(playerName1).orElseThrow(() -> new NotRegisteredException(playerName1 + " is not registered."));
        Player player2 = findPlayerByName(playerName2).orElseThrow(() -> new NotRegisteredException(playerName2 + " is not registered."));

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
