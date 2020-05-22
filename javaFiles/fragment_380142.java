Charset usedCharset = Charset.defaultCharset();

// read all lines from Convert.sql into a list
List<String> allLines = Files.readAllLines(Paths.get("Convert.sql"), usedCharset);

// append all lines from Entity.sql to the list
allLines.addAll(Files.readAllLines(Paths.get("Entity.sql"), usedCharset));

// write all lines from the list to file Entity.sql
Files.write(Paths.get("Entity.sql"), allLines, usedCharset);