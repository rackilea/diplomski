public int secondGreatest(String s) {
    String newStr = s.replaceAll("[^0-9]*", "");
    if (newStr.isEmpty() || newStr.length() == 1) {
        return -1;
    } else {
        char[] c = newStr.toCharArray();
        Arrays.sort(c);
        return c[newStr.length() - 2] - '0';
    }
}