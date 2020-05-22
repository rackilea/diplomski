public class Test {

    public static void main(String[] args) {
        boolean in = false;
        truifier(in);
        System.out.println("in is " + in);
    }

    public static void truifier (boolean bool) {
        if (bool == false) {
            bool = true;
        }
        System.out.println("bool is " + bool);
    }
}