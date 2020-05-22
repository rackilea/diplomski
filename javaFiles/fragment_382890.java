public static void main(String... args) throws IOException {
    CsvParserSettings parserSettings = new CsvParserSettings();
    parserSettings.setProcessor(new AbstractRowProcessor() {
        @Override
        public void rowProcessed(String[] row, ParsingContext context) {
            //modify the row data here.
        }
    });

    CsvWriterSettings writerSettings = new CsvWriterSettings();
    CsvRoutines routines = new CsvRoutines(parserSettings, writerSettings);

    FileReader input = new FileReader("c:/path/to/input.csv");
    FileWriter output = new FileWriter("c:/path/to/output.csv");

    routines.parseAndWrite(input, output);
}