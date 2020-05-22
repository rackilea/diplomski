public static void main(String[] args) throws IOException {
    Files.lines(Paths.get("c:/tmp/data.txt")).forEach(NameAvgFile::processLine);
}

private static void processLine(String line) {
    String[] parts = line.split(" ");
    System.out.println(parts[0] + " " + parts[1] + " " + sum(Arrays.copyOfRange(parts, 2, parts.length)));
}

private static double sum(String[] doubleStrings) {
    return Arrays.stream(doubleStrings).mapToDouble(Double::parseDouble).average().getAsDouble();
}