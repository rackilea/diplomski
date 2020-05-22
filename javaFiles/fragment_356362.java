try (Stream<Path> paths = Files.walk(Paths.get("home\path"))) {
paths
   .filter(Files::isRegularFile)
   .map(Path::getFileName)
   .collect(Collectors.toList())
   .forEach(System.out::println);
}