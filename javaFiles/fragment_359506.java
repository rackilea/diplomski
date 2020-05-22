public static void printBackwards(String s) {
    if (s.length() != 0) {
        printBackwards(s.substring(1));
        System.out.println(s.charAt(0));
    }
}