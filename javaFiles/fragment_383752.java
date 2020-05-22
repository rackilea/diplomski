public class First {
    static {
        System.out.println("first");
    }
    public static void main(final String[] args) {
        System.out.println("second");
        Second.third();
    }
}
public class Second {
    static {
        System.out.println("third");
    }
    public static void third() {
        System.out.println("fourth");
    }
}