public class A {
    void runInheritedMethod() {
        System.out.println("Hello");    
    }
}

public class B extends A {
}

public class Main {
    public static void main(String[] args) {
        // This is valid code...
        B bInstance = new B();
        bInstance.runInheritedMethod();
    }
}