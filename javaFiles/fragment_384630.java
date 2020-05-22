public class Main {
    static {
        // do something which starts threads
        System.out.println("Without main class!!! with " + System.getProperty("java.version"));
        if (true)
            throw new ThreadDeath();
    }
}