Path file = Paths.get("sample.txt");

//read all bytes from file (they will include bytes representing used line separtors)
byte[] bytesFromFile = Files.readAllBytes(file);

//convert themm to string
String textFromFile = new String(bytesFromFile, StandardCharsets.UTF_8);//use proper charset

//replace what you need (line separators will stay the same)
textFromFile = textFromFile.replaceAll("10:A", "12:A");

//write back data to file
Files.write(file, textFromFile.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);