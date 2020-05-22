public class Test {

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)(.*)" + regex, "$1" + replacement);
    }

    public static void main(String[] args) {
        System.out.println(replaceLast("aaabbb", "bb", "xx"));
    }
}