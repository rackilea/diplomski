public List<String[]> parse(File input, CsvFormat format) {
    CsvParserSettings settings = new CsvParserSettings();
    if (format == null) { //no format specified? Let's detect what we are dealing with
        settings.detectFormatAutomatically();

        CsvParser parser = new CsvParser(settings);
        parser.beginParsing(input); //just call begin parsing to kick of the auto-detection process
        format = parser.getDetectedFormat(); //capture the format
        parser.stopParsing(); //stop the parser - no need to read anything yet.

        System.out.println(format);

        if (format.getQuoteEscape() == '-') { //got something weird detected? Let's amend it.
            format.setQuoteEscape('"');
        }

        return parse(input, format); //now parse with the intended format
    } else {
        settings.setFormat(format); //this parses with the format adjusted earlier.
        CsvParser parser = new CsvParser(settings);
        return parser.parseAll(input);
    }

}