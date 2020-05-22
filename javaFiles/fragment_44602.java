public static void stringOrder(String a, String s, String d) {
    String tmp;

    if (a.compareTo(s) > 0) {
        tmp = a;
        a = s;
        s = tmp;
    }

    if (a.compareTo(d) > 0) {
        tmp = a;
        a = d;
        d = tmp;
    }

    if (s.compareTo(d) > 0) {
        tmp = s;
        s = d;
        d = tmp;
    }

    sayName(a, s, d);
}