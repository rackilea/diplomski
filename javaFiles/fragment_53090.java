public static int rotateIndex(String s1, String s2) {
    for (int i = 1; i <= s2.length(); i++) {
        if (rotate(s2, i).equals(s1)) {
            return i;
        }
    }
    return -1;
}

public static String rotate(String s, int offset) {
    int i = offset % s.length();
    return s.substring(i) + s.substring(0, i);
}

public static void main(String[] args) {
    if (args.length < 2) {
        System.out.println("Please specify two strings to compare");
        System.exit(-1);
    }

    int result = rotateIndex(args[0], args[1]);
    System.out.println(args[0] + ", " + args[1] + " => " + result);
}