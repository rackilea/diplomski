public class BLEConnection {
    private static BLEConnection singletonInstance = new BLEConnection();

    private BLEConnection() {} //constructor cannot be called from outside

    public static BLEConnection getInstance() {
        return singletonInstance;
    }

    (... your Stuff here)
}