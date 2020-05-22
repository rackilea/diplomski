public static Optional<Path> watch(Path directory, Predicate<? super Path> filter)
        throws IOException {
    try (WatchService service = directory.getFileSystem().newWatchService()) {
        directory.register(service, StandardWatchEventKinds.ENTRY_CREATE);

        long timeout = TimeUnit.NANOSECONDS.convert(2L, TimeUnit.MINUTES);
        while (timeout > 0L) {
            final long start = System.nanoTime();
            WatchKey key = service.poll(timeout, TimeUnit.NANOSECONDS);
            if (key != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    Path context = (Path) event.context();
                    if (filter.test(context)) {
                        return Optional.of(directory.resolve(context));
                    }
                }
                key.reset();
                // Accounts for the above execution time. If you don't want that you
                // can move this to before the "for" loop.
                timeout -= System.nanoTime() - start;
            } else {
                break;
            }
        }

    } catch (InterruptedException ignore) {}
    return Optional.empty();
}