public class Gamma{

    public static void main(String[] args) {
        try {
        Thread hook = new Thread() { public void run() { Beta.main(args); } };
            hook.setDaemon(true);
            Runtime.getRuntime().addShutdownHook(hook);
            Alpha.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}