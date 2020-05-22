class User {
     private List<UserScreen> screens;
     // more properties
}
class Screen {
    // screen properties
}
class UserScreen {
    private Screen screen;
    private User user;
    private int position;
}