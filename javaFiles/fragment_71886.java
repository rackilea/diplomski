public class Player {
    private final String name;

    public Player(String name) {
        this.name = Preconditions.checkNotNull(name);
    }
}