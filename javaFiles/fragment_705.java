Supplier<Integer> next(InputStreamReader reader) {
    Supplier<Integer> s = () -> {
        try {
            return reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
    return s;
}