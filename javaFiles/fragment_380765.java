Scanner scanner = new Scanner("i:\\1.txt");
scanner.useDelimiter(";");
Pattern words = Pattern.compile("(RFID=|BLUID=|WifiID=)");//just separate patterns with |
while (scanner.hasNextLine()) {
  key = scanner.findInLine(words);
  while (key != null) {
    String value = scanner.next();
    if (key.equals("RFID=") {
      System.out.print("RFID:" + value);
    } //continue with else ifs for other keys
    key = scanner.findInLine(words);
  }
  scanner.nextLine();
}