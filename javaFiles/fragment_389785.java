public class B implements SystemCycle {
    private static B instance = new B();

    private B() {}

    public static void getInstance() {
        return instance;
    }

    public void onLoad() { /* some code here */ }
    public void onLaunch() { /* some code here */ }
    public void onDispose() { /* some code here */ }

}