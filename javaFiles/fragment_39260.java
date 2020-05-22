try (Writer writer = Files.newBufferedWriter(
          Paths.get("filename.txt"), StandardCharsets.UTF_8,
          StandardOpenOption.WRITE,
          StandardOpenOption.APPEND)) {
    writer.write("something");
}