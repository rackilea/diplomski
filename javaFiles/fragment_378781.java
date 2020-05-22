// Open infoToParse file and start reading.
Scanner infoScanner = new Scanner(infoToParseFileName);

// Add exception handling.
while (infoScanner.hasNext()) {
    String line = infoScanner.nextLine();

    // Parse line and return a Person object or maybe just a Map of field names to values
    Map<String,String> personMap = dynamicParser.parse(line);
} 

infoScanner.close();