Path in_file = Paths.get("infile");
Path out_file = Paths.get("outfile");
try (BufferReader reader = Files.newBufferedReader(in_file);
         PrintWriter pw = new PrintWriter(out_file.toFile())) {

    String line;
    while((line = reader.readline()) != null) {
        if (!line.equalsIgnoreCase("cfg")) {
            pw.println(line);
        }
    }
    if (pw.checkError()) {
        throw new IOException("Exception(s) occurred in PrintWriter");
    }
}