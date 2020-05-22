CSVReader reader = new CSVReader(new FileReader("old.csv"));
CSVWriter writer = new CSVWriter(new FileWriter("new.csv"));
String [] nextLine;
while ((nextLine = reader.readNext()) != null) {
    List<String> lineAsList = new ArrayList<String>(Arrays.asList(nextLine));
    // Add stuff using linesAsList.add(index, newValue) as many times as you need.
    writer.writeNext(lineAsList.toArray());
}