static final Charset FILE_ENCODING = StandardCharsets.UTF_8;

List<String> inLines = Files.readAllLines(Paths.get("input.csv"), FILE_ENCODING);
inLines.add(0, inLines.get(inLines.size()-1));
inLines.remove(inLines.size()-1);
Files.write(Paths.get("output.csv"), inLines, FILE_ENCODING);