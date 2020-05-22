final Path p1 = Paths.get("/usr/src");
final Path p2 = Paths.get("/usr/../usr/src");

p1.equals(p2); // FALSE
Files.isSameFile(p1, p2); // true

final Path p1 = fs1.getPath("/usr/src");
final Path p2 = fs2.getPath("/usr/src");

p1.equals(p2); // FALSE