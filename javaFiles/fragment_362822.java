Reader reader = new FileReader("data.csv");
List<String[]> rows = new CSVReader(reader).readAll();

for(String[] column: rows) {
if (column[1] == "6"){
    System.out.println("Found row No. is " + rows.indexOf(column));
}
}