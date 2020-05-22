BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
String line;
Parser parser = new Parser();
List<String> names = new ArrayList<>();
List<List<String>> lotsList = new ArrayList<>();
while ((line = bufferedReader.readLine()) != null) {
    names.add(parser.parseName(line));
    lotsList.add(parser.getLots(line));
}
bufferedReader.close();