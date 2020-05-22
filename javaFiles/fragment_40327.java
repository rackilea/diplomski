public static void main(String[] args) {
    String s = "afab";
    s = replaceFirst(s, 'a', 'f');
    s = replaceFirst(s, 2, 'a', 'b');
    System.out.println(s);
}