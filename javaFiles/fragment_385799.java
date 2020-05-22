static String reverseValidate(String reversed) {
    StringBuilder str = new StringBuilder(reversed);

    for (int i = str.length() - 1; i >= 1; i--) {
        for (int j = str.length() - 1; j >= i; j--) {
            char t = str.charAt(j);
            str.setCharAt(j, str.charAt(j - 1));
            str.setCharAt(j - 1, t);
        }
    }

    return str.toString();
}