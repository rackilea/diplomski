CsvListReader reader = new CsvListReader(new FileReader(inputCsv), CsvPreference.STANDARD_PREFERENCE);
CsvListWriter writer = new CsvListWriter(new FileWriter(outputCsv), CsvPreference.STANDARD_PREFERENCE);
List<String> columns;
while ((columns = reader.read()) != null) {
    System.out.println("Input: " + columns);
    // Add new columns
    columns.add(1, "Column_2");
    columns.add("Last_column");

    System.out.println("Output: " + columns);
    writer.write(columns);
}
reader.close();
writer.close();