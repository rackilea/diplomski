try {
    stream.map(...).forEachOrdered(p -> {
        try {
            write(p);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    });
} catch (UncheckedIOException e) {
    log(e.getCause().getMessage());
}