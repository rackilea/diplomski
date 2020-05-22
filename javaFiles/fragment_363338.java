public class Test {
    private String a = "init";
    private String b = a;

    public Test(String a) {
        this.a = a;
    }

    public static void main(String[] args) {
        System.out.println(new Test("constructor").b);
    }
}