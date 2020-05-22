Path path = Paths.get("C:\\Users\\foo\\Downloads\\test.txt");
List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

int position = lines.size() / 2;
String extraLine = "This is an extraline";  

lines.add(position, extraLine);
Files.write(path, lines, StandardCharsets.UTF_8);