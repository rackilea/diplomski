public class E {

    public static void foo() {
        System.out.println("E");
    }

    public static void main(String[] args) {
        D.foo();        
    }
}

class D extends E {
    public static void foo() {
        System.out.println("D");
    }
}