public class A {
    public static A a_1;
    public static A a_2;

    public void boo() {
        A a = A.a_1;
        A b = a.a_1; // That makes a equal to b!
        A c = a.a_1.a_2; // I HATE "CHAINING" LIKE THIS
    }
}