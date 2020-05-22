CSVWriter writer = new CSVWriter(
    new OutputStreamWriter(new FileOutputStream("example.csv"), StandardCharsets.UTF_8),
    ';',
    CSVWriter.DEFAULT_QUOTE_CHARACTER,
    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
    CSVWriter.DEFAULT_LINE_END
);