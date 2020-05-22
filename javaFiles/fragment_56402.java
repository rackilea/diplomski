Reader reader = new InputStreamReader(new FileInputStream("persons.csv"), "UTF-8");

//bring in the first line with the headers if you want them
List<String> firstRow = CSVHelper.parseLine(reader);

List<String> dataRow = CSVHelper.parseLine(reader);
while (dataRow!=null) {

    ...put your code here to construct your objects from the strings

    dataRow = CSVHelper.parseLine(reader);
}