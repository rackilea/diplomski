public class MultipleMain {

    public static void main(String[] args) {
        System.out.println("Hello World!!!! I must be executing");
        AnotherWithMain.main(new String[]{});
    }
}


class AnotherWithMain {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}