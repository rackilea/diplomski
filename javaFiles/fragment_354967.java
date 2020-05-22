List<String> trimmedLines = Files.readLines(file, Charsets.UTF_8,
  new LineProcessor<List<String>>() {
    List<String> result = Lists.newArrayList();

    public boolean processLine(String line) {
      result.add(line.trim());
    }
    public List<String> getResult() {return result;}
  });