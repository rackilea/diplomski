StringReader reader = new StringReader("ramarim 129202 cinza");
LetterTokenizer stream = new LetterTokenizer(Version.LUCENE_42, reader);        
stream.setReader(reader);
stream.reset();
while(stream.incrementToken()) {
    System.out.println(stream.reflectAsString(false));
}
stream.close();