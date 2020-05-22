FixedWidthParserSettings settings = new FixedWidthParserSettings(fields);
settings.getFormat().setLineSeparator("\n");
settings.setRecordEndsOnNewline(false);

FixedWidthParser parser = new FixedWidthParser(settings);

List<String[]> rows = parser.parseAll(new StringReader(input));
for (String[] row : rows) {
    System.out.println(Arrays.toString(row));
}