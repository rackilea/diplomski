public class Main {

    public static <T> void concatenate(T arg1, T arg2) {
        System.out.println(arg1.toString() + arg2.toString());
    }

    public static void main(String[] args) {
        Main.<String>concatenate("one", "two"); // will work just fine, outputs "onetwo"
        Main.<Integer>concatenate(1, 2); // will also work great, outputs 12
        Main.<String>concatenate("one", 2); // will fail at compile time
    }
}