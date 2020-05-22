private static void readWrite(Path filePath) throws IOException {
    List<String> allLines = Files.readAllLines(filePath);
    int count = 0;
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile()))) {
      for (String line : allLines) {
        if (line.trim().contains("Scenario")) {
          count++;
          bw.write("@tag" + count);
          bw.write("\n");
        }
        bw.write(line);
      }
    }
  }