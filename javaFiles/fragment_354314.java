public class User implements Entity<Integer> {

    private Integer id;

    public User(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

}

public class UserDao implements Dao<Integer, User> {

    @Override
    public User create(User entity) {
        // build query
    }

    @Override
    public User update(User entity) {
        // build query
    }

    @Override
    public User delete(User entity) {
        // build query
    }

    @Override
    public User get(Integer id) {
        // build query
    }

    @Override
    public List<User> getAll() {
        // build query
    }

}