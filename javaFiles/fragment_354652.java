public static void main(String[] args) {
    final String msg = "msg to show";
    final byte[] command = { 2, 5, 1, 5 };

    // Prints [2, 5, 1, 5, m, s, g,  , t, o,  , s, h, o, w]
    System.out.println(Arrays.toString(concat(msg, command)));
}

private static char[] concat(final byte[] bytes, final String str) {
    final StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
        sb.append(b);
    }
    sb.append(str);
    return sb.toString().toCharArray();
}