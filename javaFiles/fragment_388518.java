public static String reverse(String str) {
    if (str.length() <= 1)
        return str;
    else
        return Character.toString(str.charAt(str.length() - 1))
                + reverse(str.substring(0, str.length() - 1));
}