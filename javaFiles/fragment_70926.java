BufferedReader fileReader = new BufferedReader(new FileReader("./test.json"));
ObjectMapper mapper = new ObjectMapper();
Quotes quotes = mapper.readValue(fileReader, Quotes.class);
for (Phrases element : quotes.getFamous_phrases()) {
  System.out.println(element.getPhrase1());
}