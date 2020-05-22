public final class Stats {
    ...
    private static Stats instance = null;
    public static Stats getInstance()
    {
        if (instance == null)
            instance = new Stats();
        return instance;
    }
}