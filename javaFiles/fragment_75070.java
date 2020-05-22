Path in_file = Paths.get("infile");
Path out_file = Paths.get("outfile");
try (PrintWriter pw = new PrintWriter(out_file.toFile())) {
    Files.lines(in_file)
         .filter(line -> !line.equalsIgnoreCase("cfg"))
         .forEach(pw::println);
    if (pw.checkError()) {
        throw new IOException("Exception(s) occurred in PrintWriter");
    }
}