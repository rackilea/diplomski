import java.util.regex.*;

class T {
    public static void main(String[] args) {
        String word = "A a =new A(); a.call();";
        Pattern pattern = Pattern.compile("[a-zA-Z_]\\w*\\.[a-zA-Z_]\\w*\\(.*?\\)");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}