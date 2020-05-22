public class Main {
    public static void main(String[] args) {
        System.out.println(isNotContained("abc", "dc"));
        System.out.println(isNotContained("abc", "de"));
    }

    private static boolean isNotContained(final String source, final String target) {
        char[] original = source.toCharArray();
        for (char c : original) {
            if (target.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}