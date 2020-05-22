public class Example {
    public static void main(String[] args) {
        char a = 1;
        char b = 2;

        char c = a + b;          // error: incompatible types: possible lossy conversion from int to char
        System.out.println(c);
    }
}