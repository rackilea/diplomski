public class UserDaoFactory {
    public UserDao create() {
        if (SomeSharedSingleton.getInstance().getPersistenceOption() == JDBC) {
            return new UserDAOImplJDBC();
        }
        else {
            return new UserDAOImplJPA();
        }
    }
}