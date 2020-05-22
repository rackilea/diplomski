// create a new Parser object
Parser parser = new Parser();
// get name
System.out.println(parser.parseName(line));
// get lots
List<String> lotList = parser.getLots(line);
for (String lot : lotList) {
    System.out.println(lot);
}