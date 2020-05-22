List<Future<String>> futures = new ArrayList<>();
for (String pathname : pathnames) {
    futures.add(pool.submit(new Runner(pathname));
}
for (Future<String> future : futures) {
    ...
}