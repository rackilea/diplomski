try (Stream<Path> paths = Files.walk(Paths.get("home\path"))) {
paths
   .filter(Files::isRegularFile)
   .filter(path -> path.toString().toLowerCase().endsWith(".txt"))
   .map(Path::getFileName)
   .collect(Collectors.toList())
   .forEach(System.out::println);
}