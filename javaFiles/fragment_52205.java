// the singletons tokenization/POS-tagging pipeline 
String[] tokens;
synchronized(tokenizer) { 
   tokens = tokenizer.tokenize(text);
}
String[] tags;
synchronized(posTagger) { 
   tags = posTagger.tag(tokens);
}