final Path path1 = Paths.get("/path/to/file1");
final Path path2 = Paths.get("/path/to/file2");
final Path outfile = Paths.get("/path/to/outfile");

final List<String> list1 = Files.readAllLines(path1, StandardCharsets.UTF_8);
final List<String> list2 = Files.readAllLines(path2, StandardCharsets.UTF_8);

list2.removeAll(list1);

Files.write(outfile, list2, StandardCharsets.UTF_8);