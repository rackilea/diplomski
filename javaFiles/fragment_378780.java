// Create new parser to hold parsing steps.
Parser dynamicParser = new Parser();

// Create new scanner to read through parse file.
Scanner parseFileScanner = new Scanner(howToParseFileName);

// *** Add exception handling as necessary *** this is just an example    

// Read till end of file.
while (parseFileScanner.hasNext()) {
    String line = parseFileScanner.nextLine(); // Get next line in file.

    String[] lineSplit = line.split(","); // Split on comma
    String fieldName   = lineSplit[0];
    String dataType    = lineSplit[1];
    String dataLength  = lineSplit[2];  // Convert to Integer with Integer.parseInt();

    ParsingStep step = new ParsingStep(fieldName, dataType, dataLength);
    dynamicParser.addStep(step);
}

parseFileScanner.close();