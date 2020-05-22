public class Test {
    public static void main(String[] args) {
        String string = "A3";
        int parseInt = Integer.parseInt(string, 16);
        System.out.println(parseInt);
        System.out.println(Integer.toBinaryString(parseInt));
    }
}