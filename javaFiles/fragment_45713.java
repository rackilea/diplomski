public class LambdaAppJava8 {
    private interface MyInterface {
        public int call(int a, int b);
    }
    public int fonk(int a, int b, MyInterface anonim) {
        return anonim.call(a, b);
    }
    public static void main(String[] args) {
        LambdaAppJava8 app = new LambdaAppJava8();
        System.out.println(app.fonk(1, 3, (c, d) -> c + d));
    }
}