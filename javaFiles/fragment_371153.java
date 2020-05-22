public class Sample {
    static void doSomething(InputStream is) {
        System.out.println("is");
    }

    static void doSomething(OutputStream os) {
        System.out.println("os");
    }

    public static void main(String args[]) {
        System.out.println(doSomething(null)); // "compilation" error . Ambiguous call. Both InputStream and OutputStream can take `null` argument.
    } 

}