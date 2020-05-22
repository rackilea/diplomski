List<String> paths = ...;

paths.stream().map(path -> {
    try (Stream<Path> stream = Files.list(Paths.get(path))) {
        return stream.filter(p -> !p.toFile().isDirectory()).filter(p -> p.toString().endsWith(".json"))
                .map(Path::toString).collect(Collectors.joining("\n"));
    } catch (IOException e) {
        // Log your ERROR here.
        e.printStackTrace();
    }
    return "";
}).forEach(System.out::println);