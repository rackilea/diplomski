Path path = Paths.get(file.getAbsolutePath());
Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
        for (String line : (Iterable<String>) stream::iterator) {
        //do stuff
        }   
}