try (
  BufferedReader in = new BufferedReader(new FileReader("inputFile.txt"));
  PrintWriter out = new PrinterWriter(new FileWriter("outputFile.txt"));
) {

  MaxentTagger tagger = new MaxentTagger("tag/wsj-0-18-bidirectional-distsim.tagger");    
  String line;
  while ((line = in.readLine()) != null) {
    String tagged = tagger.tagString(line);
    out.println(tagged);
  }
}