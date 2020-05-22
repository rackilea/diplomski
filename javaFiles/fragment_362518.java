private static String upperEven(String s) {
    char[] c = s.toCharArray();
    boolean t = false;
    for (int i = 0; i < c.length; i++)
        if (Character.isLetter(c[i]))
            c[i] = ((t = ! t) ? Character.toLowerCase(c[i]) : Character.toUpperCase(c[i]));
    return new String(c);
}