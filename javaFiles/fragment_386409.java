public static void main(String[] args) {
    int threads = Runtime.getRuntime().availableProcessors();
    Counter c = new Counter(threads);
    for (int  i=0; i<threads; i++) {
        ...
    }
}