class UserExecutor extends AbstractExecutor<User> {

    @Override
    public User create(String name) {
        return new User(name);
    }

    // ...
}