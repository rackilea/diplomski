Scanner fileScanner = new Scanner(myFile);
while (fileScanner.hasNextLine()) {
  String line = fileScanner.nextLine();

  Scanner lineScanner = new Scanner(line);
  while (lineScanner.hasNext()) {
    String token = lineScanner.next();
    // do whatever needs to be done with token
  }
  lineScanner.close();
  // you're at the end of the line here. Do what you have to do.
}
fileScanner.close();