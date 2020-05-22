private void createDocument() throws FileNotFoundException {
    File sjp = new File(dictionaryPath);
    BufferedReader reader = new BufferedReader(new FileReader(sjp));

    String readLine = null;
    while((readLine = reader.readLine() != null)) {
        readLine = readLine.trim();
        Document dictionary = new Document();
        dictionary.add(new Field("word", readLine));
        // toAnagram methods sorts the letters in the word. Also makes it
        // case insensitive.
        dictionary.add(new Field("anagram", toAnagram(readLine)));
        indexWriter.addDocument(dictionary);
    }
}