public class UserServiceFactory {

    private UserServiceFactory () {}

    private static class UserServiceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    public static UserService getInstance() {
        return UserServiceHolder.INSTANCE;
    }

}