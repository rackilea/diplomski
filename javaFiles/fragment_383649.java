PrintStream ps = new PrintStream(new FileOutputStream("C:/Users/example.csv"));    List<String> record = new ArrayList<>();
// ...
for (int i=0; i < id.length; i++) {
    record.add(id[i] + "\t");    
    record.add(wec[i] + "\t");    
}
try (CSVPrinter csvPrinter = new CSVPrinter(builder, CSVFormat.EXCEL)) {
        csvPrinter.printRecord(record);
}