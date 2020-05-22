// Define your attribute factory (or use the default) - same between 4.x and 5.x
AttributeFactory factory = AttributeFactory.DEFAULT_ATTRIBUTE_FACTORY;

// Create the tokenizer and prepare it for reading
//  Lucene 4.x
StandardTokenizer tokenizer = 
        new StandardTokenizer(factory, new StringReader("Tokenize me!"));
tokenizer.reset();
//  Lucene 5.x
StandardTokenizer tokenizer = new StandardTokenizer(factory);
tokenizer.setReader(new StringReader("Tokenizer me!"));
tokenizer.reset();

// Then process tokens - same between 4.x and 5.x
// NOTE: Here I'm adding a single expected attribute to handle string tokens,
//  but you would probably want to do something more meaningful/elegant
CharTermAttribute attr = tokenizer.addAttribute(CharTermAttribute.class);
while(tokenizer.incrementToken()) {
    // Grab the term
    String term = attr.toString();

    // Do something crazy...
}