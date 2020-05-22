public class MainApp {
    public User user = new User(); // Instance 1
}

public class ServerController {
    private User user;

    public ServerController(GameConfig gameConfig) {
        this.user = new User(); // Instance 2
        ...
    }
}