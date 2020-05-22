private static final String[] REPLACEMENT = new String[Character.MAX_VALUE+1];
static {
    for(int i=Character.MIN_VALUE;i<=Character.MAX_VALUE;i++)
        REPLACEMENT[i] = Character.toString(Character.toLowerCase((char) i));
    // substitute
    REPLACEMENT['á'] =  "a";
    // remove
    REPLACEMENT['-'] =  "";
    // expand
    REPLACEMENT['æ'] = "ae";
}

public String convertWord(String word) {
    StringBuilder sb = new StringBuilder(word.length());
    for(int i=0;i<word.length();i++)
        sb.append(REPLACEMENT[word.charAt(i)]);
    return sb.toString();
}