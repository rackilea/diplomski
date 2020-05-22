CSVFormat csvFormat = CSVFormat.DEFAULT.withNullString("");
CSVParser csvParser = new CSVParser(fileReader, csvFormat);
for (CSVRecord csvRecord : csvParser.getRecords()) {
    String values[] = {csvRecord.get(0), csvRecord.get(1), csvRecord.get(2)};
    for (String value : values) {
        if (value != null) {
            // as soon a value is not-null we add the array
            // and exit the for-loop
            csvContentsList.add(values);
            break;
        }
    }
}