// Ideally have this as a constant somewhere.
Charset utf8 = Charset.forName("UTF-8");

BufferedReader reader = new BufferedReader(new InputStreamReader(
    new FileInputStream(inputFile), utf8);
try {
  try {
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(outputFile), utf8);

    String line;
    while ((line = reader.readLine()) != null) {
      if (!line.contains(name)) {
        writer.write(line);
        writer.newLine();
      }
    }
  } finally {
    writer.close();
  }
} finally {
  reader.close();
}
// Now if you want to shift files around, do it here