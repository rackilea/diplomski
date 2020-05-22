interface Cache<T> {}

static void logProgress(Map<String, Future<?>> futures) {}

public static void main (String[] args) {
    Map<String, Future<Cache<?>>> map = new HashMap<>();
    logProgress(map);  // Compiler error.
}