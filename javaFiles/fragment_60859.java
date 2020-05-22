public class Main {
    public static void main(String[] args) {
        // sayHello(); // Compilation error as you are calling the non-static method directly from a static method
        Main main = new Main();
        main.sayHello();// OK as you are calling the non-static method from a static method using the object of the class
    }

    void sayHello() {
        System.out.println("Hello");
    }
}