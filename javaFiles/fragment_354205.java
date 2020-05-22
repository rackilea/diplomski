Files.write(Paths.get("/your/folder/text.txt"),
    "Hello World!".getBytes(StandardCharsets.UTF_8));

// Or
Files.write(Paths.get("/your/folder/text.txt"),
    Arrays.asList("Hello World!"), StandardCharsets.UTF_8);