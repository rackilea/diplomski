public class GlobalKeyListener {

    // rest of class omitted
    private static GlobalKeyListener INSTANCE = new GlobalKeyListener();

    public static GlobalKeyListener getInstance() { 
        return INSTANCE;
    }

}