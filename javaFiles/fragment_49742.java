public class StringCleaner {

    public static void main(String[] args) {
        StringCleaner sc = new StringCleaner();
        System.out.println(sc.cleanFilename("this has a space"));
        System.out.println(sc.cleanFilename("this has a plus +"));
        System.out.println(sc.cleanFilename("this is full :\\/*?|<> + of stuff"));
    }

    private static final Pattern illegalfilechars = Pattern.compile("[:\\/*?|<> +]");
    private static final Pattern illegaldirchars = Pattern.compile("[:\\*?|<> +]");

    private static final String replaceall(Pattern pattern, String dirtyString) {
        Matcher mat = pattern.matcher(dirtyString);
        if (!mat.find()) {
            return dirtyString;
        }
        StringBuffer sb = new StringBuffer();
        do {
            mat.appendReplacement(sb, "+" + (int)mat.group(0).charAt(0) + "+");
        } while (mat.find());
        mat.appendTail(sb);
        return sb.toString();
    }

    public static String cleanFilename(String dirtyString) {
        return replaceall(illegalfilechars, dirtyString);
    }

    public static String cleanDirectory(String dirtyDirectory) {
        return replaceall(illegaldirchars, dirtyDirectory);
    }
}