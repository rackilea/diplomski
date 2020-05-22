DocumentCategorizer categorizer = new DocumentCategorizerME(model);

// could also use: Tokenizer tokenizer = new TokenizerME(tokenizerModel)
Tokenizer tokenizer = WhitespaceTokenizer.INSTANCE();

 // linesample is like in your question...
for(String sample=linesample.read(); sample != null; sample=linesample.read()){
    String[] tokens = tokenizer.tokenize(sample);
    double[] outcomeProb = categorizer.categorize(tokens);
    String sampleOutcome = categorizer.getBestCategory(outcomeProb);

  // check if the outcome is right...
  // keep track of # right and wrong...
}
// calculate agreement metric of your choice