public class Test {
    private final String a;
    private String b = a; // // Variable 'a' might not have been initialized

    public Test(String a) {
        this.a = a;
    }
}