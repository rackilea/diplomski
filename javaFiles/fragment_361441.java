import java.util.regex.*;


public class ReverseRegex{
    public static void main(String[] args) {
        String str = "hello &fjeaifjiajwta; world";
        String[] parts = str.split("&([A-Za-z]+|[0-9]+|x[A-Fa-f0-9]+);");
        for (int i = 0; i < parts.length; i++) {
            System.out.println(parts[i]);
        }
    }
}