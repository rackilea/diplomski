// if you want to work line by line, use Files.readAllLines()
// if you use Guava, there's also Guava's Files.toString() for reading the whole file into a String
byte[] bytes = Files.readAllBytes(Paths.get("test.txt"));
String text = new String(bytes, StandardCharsets.UTF_8);

IntStream codePoints = text.codePoints();

// do something with the code points
codePoints.forEach(codePoint -> System.out.println(codePoint));