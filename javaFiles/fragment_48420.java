public class VarargsDemo {
    public static void f(String... args) {
        for (String s: args) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        String[] english = new String[]{"one", "two", "three"};
        f(english);
        f("uno", "dos", "tres");
    }
}