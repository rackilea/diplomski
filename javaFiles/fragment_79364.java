public class Overload {
    public static void main(String args[]) {
        Overload overload = new Overload();
        overload.methodOne();
        overload.methodOne(8);
    }
    void methodOne() {
        System.out.println("no arguments");
    }    
    void methodOne(int x) {
        System.out.println("integer value=" + x);
    }
}