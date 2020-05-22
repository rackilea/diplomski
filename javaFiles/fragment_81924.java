public static String removeWhitespaces(String source){
    char[] chars = new char[source.length()];
    int numberOfNewlines = 0;
    for (int i = 0; i<chars.length; i++){
        if (source.charAt(i)==' ')
            numberOfNewlines++;
        else
            chars[i-numberOfNewlines]=source.charAt(i);
    }
    return new String(chars).substring(0, source.length()-numberOfNewlines);
}