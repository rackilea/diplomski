Reader in = new StringReader(
            "DAR_123451                  ,\"XXXXX Hello World \"\"Hello World XXX\"\" \"\n" +
                    "DAR_123452                  ,\"XXXXX Hello World \"\"Hello World XXX\"\" \"");
    Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
    for (CSVRecord record : records) {
        for (int i = 0; i < record.size(); i++) {
            System.out.println("At " + i + ": " + record.get(i));
        }
    }