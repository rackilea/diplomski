public static void main(String... args) {
    //this is your output file
    File output = new File("c:/path/to/output.csv");

    //configure the writer if you need to
    CsvWriterSettings settings = new CsvWriterSettings();

    //create the writer. Here we write to a file
    CsvWriter writer = new CsvWriter(output, settings);

    //get the row iterator
    IterableResult<String[], ParsingContext> rows = readCSV("c:/temp");

    try {
        //do whatever you need to the rows here
        for (String[] row : rows) {
            //then write it each one to the output.
            writer.writeRow(row);
        }
    } finally {
        //cleanup
        rows.getContext().stop();
        writer.close();
    }
}