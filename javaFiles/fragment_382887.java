public static IterableResult<String[], ParsingContext> readCSV(String filePath) {
    File file = new File(filePath);

    //configure the parser here. By default all values are trimmed
    CsvParserSettings parserSettings = new CsvParserSettings();

    //create the parser
    CsvParser parser = new CsvParser(parserSettings);

    //create an iterable over rows. This will not load everything into memory.
    IterableResult<String[], ParsingContext> rows = parser.iterate(file);

    return rows;
}