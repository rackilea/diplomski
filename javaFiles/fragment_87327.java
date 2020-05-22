// before your loop starts
boolean currentlyParsingRecord = false;
boolean List<String> rawRecordLines = new ArrayList<>();

// within your loop
String line = scanner.nextLine();
if (currentlyParsingRecord) {
  if (line.startsWith("6220)) { 
    currentlyParsingRecord = false;
  }
  rawRecordLines.add(line);
} else {
  if (line.startsWith("6220)) { 
    currentlyParsingRecord = true;
    rawRecordLines.add(line);
    // and now, maybe you are calling a method like
    processRecordLines(rawRecordLines);
    // and then you clear your "buffer"
    rawRecordLines.clear();
  }
}