public class Test {
    private final String a;
    private String b = getA(); // allowed now, but not very useful
    private Function<String, String> f = e -> getA(); // allowed now and evaluated at the time of execution of the function

    public Test(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(new Test("constructor").b); // prints "null"
        System.out.println(new Test("constructor").f.apply("")); // prints "constructor"
    }

    public String getA() {
        return a;
    }
}