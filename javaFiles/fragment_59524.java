public static int symmetric(int a) {
    if (Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString()))
        return a;
    else
        return 0;
}