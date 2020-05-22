package launch;

public class Launcher {
    public static void main(String[] args) throws Exception {
        System.out.println("I am the launcher!");
        Class<?> clazz = Class.forName(args[0]);
        Launchable launchable = (Launchable) clazz.newInstance();
        launchable.launch();
    }
}