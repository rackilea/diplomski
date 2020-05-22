public class MyApplication  {
    static String test2 = "";
    public static void main(String[] args) {
        try {
            int test = Integer.parseInt("123");
            test2 = "ABCD";
        } catch (NumberFormatException ex) {
            System.out.print(ex.getMessage());
        }
    }
}