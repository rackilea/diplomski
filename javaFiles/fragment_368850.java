File initialFile = new File("/Users/me/Downloads/file.csv");
InputStream targetStream = FileUtils.openInputStream(initialFile);

CsvParserSettings settings = new CsvParserSettings();
settings.getFormat().setLineSeparator("\n");

CsvParser parser = new CsvParser(settings);
List<String[]> allRows = parser.parseAll(new InputStreamReader(targetStream, "UTF-8"));