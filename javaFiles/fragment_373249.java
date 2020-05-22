public class Singleton {
    private static class Holder {
        static final Singleton INSTANCE = new Singleton ();
    }

    public static Singleton getInstance() {
        return Holder.INSTANCE;
    }

    private Singleton () {
    }
    // rest of class omitted
}