private static GreetingServiceImpl instance = null;
public static GreetingServiceImpl getInstance() {
    if (instance == null) {
        instance = new GreetingServiceImpl();
    }
    return instance;
}