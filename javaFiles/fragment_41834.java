try {
    ....
} finally {
    for (Future<T> f : futures)
        f.cancel(true);
}