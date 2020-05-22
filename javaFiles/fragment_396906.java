public static void main(String[] args) {
  InputStream inStream = GetData.class.getResourceAsStream(DATA_FILE);
  List<Cruise> cruiseList = new ArrayList<>();
  Scanner input = new Scanner(inStream);
  while (input.hasNext()) {
     String name = getLine(input);
     String id = getLine(input);
     int length = Integer.parseInt(getLine(input));
     int crew  = Integer.parseInt(getLine(input));

     // assuming a class called Cruise
     Cruise cruise = new Cruise(name, id, length, crew);

     for (int i = 0; i < crew; i++) {
        cruise.addPayRate(Double.parseDouble(getLine(input)));
     }

     cruiseList.add(cruise);
  }

  input.close();
}

private static String getLine(Scanner input) {
  String line = input.nextLine();

  // get rid of white space followed by "//" followed by anything
  line = line.replaceAll("\\s+//.*", "");
  return line;
}