paths.stream().map(path -> {
    try (Stream<Path> stream = Files.walk(Paths.get(path))) {
        return stream.filter(p -> !p.toFile().isDirectory()).filter(p -> p.toString().endsWith(".json"))
                .map(Path::toString).collect(Collectors.toList());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return Collections.emptyList();
}).flatMap(List::stream).forEach(System.out::println);