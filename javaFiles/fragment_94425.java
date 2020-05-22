// Text mode
List<String> lines = Files.readAllLines(inputPath);
// do something with lines
Files.write(outputPath, lines);

// Binary mode
byte[] content = Files.readAllBytes(inputPath);
// do something with content
Files.write(outputPath, content);