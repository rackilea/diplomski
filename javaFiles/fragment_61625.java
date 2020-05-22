public void println(String x) {
    synchronized (lock) {
        print(x);
        println();
    }
}

public void print(String s) {
    if (s == null) {
        s = "null";
    }
    write(s);
}