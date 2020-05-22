class CachingUserRepository implements UserRepository {
    private Cache cache;
    private UserRepository delegate;

    List<User> retrieveUsers() {
        List<User> result = cache.get(USERS_KEY);
        if (result == null) {
            result = delegate.retrieveUsers();
        }

        return result;
    }

}