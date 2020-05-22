private static String readNextAndLog(Scanner sc) {
    String s = sc.next();

    for (int i = 0; i < s.length(); i++) {
        System.out.println((int)s.charAt(i));
    }

    return s;
}