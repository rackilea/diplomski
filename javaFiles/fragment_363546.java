import pkg1.SomeClass;

public class Main {

    public static void main(String args[]) {
        new SomeClass();
        new pkg2.SomeClass();   // <-- not imported.
    }
}