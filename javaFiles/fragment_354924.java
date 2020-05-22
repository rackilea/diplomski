public static void main(String[] args) {
  FileInputStream fis = new FileInputStream("FileName.CSV");
  BufferedInputStream bis = new BufferedInputStream(fis);
  InputStreamReader isr = new InputStreamReader(bis);
  BufferedReader br = new BufferedReader(isr);

  processCSV(br);
}

private static void processCSV(BufferedReader reader) {
  fetchHeaders(reader);
  processContentRows(reader);
}

private static void fetchHeaders(BufferedReader reader) {
   // Use reader.readLine() here directly... do *not* create
   // another BufferedReader on top.
}

private static void processContentRows(Reader reader) {
  // This could be declared to take a BufferedReader if you like,
  // but it doesn't matter much.
}