public void println(String x) {
    synchronized (this) {
        print(x);
        newLine();
    }
}