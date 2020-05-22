public class User {
    private static User USER;

    public static User getInstance() {
        if(null == USER) {
            USER = new User();
        }
        return USER;
    }
}

public class MainApp {
    public Game createPlayer() {
        User user = User.getInstance();
        List<String> userNames = user.getUserNames();
    }
}