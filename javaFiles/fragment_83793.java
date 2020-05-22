public class Main {
    static AtomicBoolean isInSession = new AtomicBoolean(); // default value is false
    static AtomicBoolean sessionOver = new AtomicBoolean();

    public static void main (String [] args)
    {
        for (int i = 0; i < 25; i++) {
            Visitor visitor = new Visitor(i, isInSession);
            visitor.start();
        }
        Thread clock = new Thread(new Clock(isInSession, sessionOver));
        clock.start();
    }
}