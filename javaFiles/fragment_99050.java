public class World {

    private Map<String, Player> players = new HashMap<>();

    public Collection<Player> getPlayers() { ... }

    public Optional<Player> getPlayer(String nickname) { ... }

    // ...
}