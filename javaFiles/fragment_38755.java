public void println(int x) {
    synchronized (this) {
        print(x);
        newLine();
    }
}