public interface UserDAO {
    // ..
}

public class DBUserDAO implements UserDAO {

    private final Connection conn;

    public DBUserDAO(Connection conn) {
        this.conn = conn;
    }

    // ..
}

Container container = new MentaContainer();

c.ioc(Connection.class, connFactory);
c.ioc(UserDAO.class, DBUserDAO.class);
c.autowire(Connection.class);