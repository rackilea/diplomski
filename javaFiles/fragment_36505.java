public class Function {
    private static int last = 0;
    public static int foo(int n) {
        last += n; 
        return last; 
    }
}