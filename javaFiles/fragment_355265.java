System.out.println(containsHanScript("xxx已下架xxx"));

public static boolean containsHanScript(String s) {
    for (int i = 0; i < s.length(); ) {
        int codepoint = s.codePointAt(i);
        i += Character.charCount(codepoint);
        if (Character.UnicodeScript.of(codepoint) == Character.UnicodeScript.HAN) {
            return true;
        }
    }
    return false;
}