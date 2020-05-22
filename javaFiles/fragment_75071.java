Path path = new Path("filename");
List<String> lines = Files.lines(path)
                          .filter(line -> !line.equalsIgnoreCase("cfg"))
                          .collect(Collectors.toList());

try(PrintWriter pw = new PrintWriter(path.toFile())) {
    lines.forEach(pw::println);
    if (pw.checkError()) {
        throw new IOException("Exception(s) occurred in PrintWriter");
    }
}