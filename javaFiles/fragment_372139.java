public static void main(String ... args) throws Exception{

    Writer output = new StringWriter(); // use a FileWriter for your case

    CsvWriterSettings writerSettings = new CsvWriterSettings(); //many options here - check the documentation
    final CsvWriter writer = new CsvWriter(output, writerSettings);

    CsvParserSettings parserSettings = new CsvParserSettings();  //many options here as well
    parserSettings.setHeaderExtractionEnabled(true); // indicates the first row of the input are headers

    parserSettings.setRowProcessor(new AbstractRowProcessor(){

        public void processStarted(ParsingContext context) {
            writer.writeHeaders("Column A", "Column B", "... etc");
        }

        public void rowProcessed(String[] row, ParsingContext context) {
            writer.writeRow(row);
        }

        public void processEnded(ParsingContext context) {
            writer.close();
        }
    });

    CsvParser parser = new CsvParser(parserSettings);
    Reader reader = new StringReader("A,B,C\n1,2,3\n4,5,6"); // use a FileReader for your case
    parser.parse(reader); // all rows are parsed and submitted to the RowProcessor implementation of the parserSettings.

    System.out.println(output.toString());
    //nothing else to do. All resources are closed automatically in case of errors.
}