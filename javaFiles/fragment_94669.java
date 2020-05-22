class String {
}

public class CarelessMain {
    public static void main(String[] args) {
        System.out.println("won't get printed");
    }
    public static void main(java.lang.String[] args) {
        System.out.println("worked");
    }
}