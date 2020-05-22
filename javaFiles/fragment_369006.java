public class MyThreadLocal {

    public static final ThreadLocal userThreadLocal = new ThreadLocal();

    public static void set(User user) {
        userThreadLocal.set(user);
    }

    public static void unset() {
        userThreadLocal.remove();
    }

    public static User get() {
        return userThreadLocal.get();
    }
}