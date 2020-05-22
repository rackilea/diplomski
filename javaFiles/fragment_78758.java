String[] result;
try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
    result = stream.map(Path::toString)
            .filter(s -> s.endsWith(".txt"))
            .sorted()
            .toArray(String[]::new);
}

for (int i = 0; i < result.length; i++) {
    // do something
}