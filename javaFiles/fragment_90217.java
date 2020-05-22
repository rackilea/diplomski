private static final class DeferredLoader {
    static final UserCache INSTANCE = new UserCache();
}

public static UserCache getInstance() {
    return DeferredLoader.INSTANCE;
}