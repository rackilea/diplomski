public class Test {
    public static void main(String[] args) {
        String name = "F. J. Hill";
        String[] split = name.split(" ");
        int size = split.length - 1;
        System.out.println(split[size]);
    }
}