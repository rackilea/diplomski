@Override
 protected TokenStreamComponents createComponents(String fieldName) {
   Tokenizer source = new FooTokenizer();
   TokenStream filter = new FooFilter(source);
   filter = new BarFilter(filter);
   return new TokenStreamComponents(source, filter);
 }