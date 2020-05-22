public void println(Object x) {
    String s = String.valueOf(x);
    synchronized (lock) {
        print(s);
        println();
    }
}

public static String valueOf(Object obj) {
    return (obj == null) ? "null" : obj.toString();
}