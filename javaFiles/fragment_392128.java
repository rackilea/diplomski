public class Superclass {
    public static long INIT_TIME = System.currentTimeMillis();

    static {
        System.out.println("Initializing Superclass");
    }
}

public class Subclass extends Superclass {
    static {
        System.out.println("Initializing Subclass");
    }
}