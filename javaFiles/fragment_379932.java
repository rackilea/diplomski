public class First {
    public First(String first) {
        System.out.println("in first");
    }
}

public class Second extends First {
    public Second(String second) {
        super(second);
        System.out.println("in second");
    }
}

public class Third extends Second {
    public Third(String third) {
        super(third);
        System.out.println("in third");
    }

    public static void main(String[] args) {
        new Third("yay!");
    }
}