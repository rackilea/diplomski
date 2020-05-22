import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public static String trimUtf16(String test) {
        Pattern unicode = Pattern.compile("[^\\x00-\\x7F]",
                Pattern.UNICODE_CASE | Pattern.CANON_EQ
                        | Pattern.CASE_INSENSITIVE);
        Matcher matcher = unicode.matcher(test);
        test = matcher.replaceAll(" ");
        return test;
    }
    System.out.println(trimUtf16("\u0000\u001f\u0085 hi \n"));// hi