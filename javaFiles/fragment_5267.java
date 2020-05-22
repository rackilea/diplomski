List<String[]> returnList = new ArrayList<>();

public CSVReaderMock returnLines(@NonNull List<String> lines) {
  try {
    for (String line : lines) {
      String[] lineArr = null;
      if (line != null) {
        lineArr = line.split(",");
      }
      returnList.add(lineArr);
    }
    linesCorrectInitialized = true;
  } catch (IOException e) { /* ... */ };
  return this;
}

public CSVReader create() {
  if (!linesCorrectInitialized) { /* ... */ }
  // Return null repeatedly after all stubs are exhausted.
  returnList.add(null);
  when(reader.readNext()).thenAnswer(new ReturnsElementsOf(returnList));
  return reader;
}