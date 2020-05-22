public class Salmon {
    public static void main(String[] args) {

        String str1 = "Str1";
        String str2 = new String("Str1");

        if (str1 == str2) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }
    }
}