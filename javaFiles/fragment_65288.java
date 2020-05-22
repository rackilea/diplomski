public class Test {

    public static String replaceLast(String text, String regex, String replacement) {
        return text.replaceFirst("(?s)"+regex+"(?!.*?"+regex+")", replacement);
    }

    public static void main(String[] args) {
        System.out.println(replaceLast("foo AB bar AB done", "AB", "--"));
    }
}