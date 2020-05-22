@Test
public void fieldSelectionTest() throws Exception {
    CsvParserSettings settings = new CsvParserSettings();
    settings.setHeaderExtractionEnabled(true);
    settings.getFormat().setLineSeparator("\n");
    settings.setNullValue("N/A"); //null value here

    settings.selectFields("Year", "???");

    CsvParser parser = new CsvParser(settings);

    String input = "" +
            "Year,Header1,Header2\n" +
            "2000,foo,bar\n" +
            "2016,blah,etc\n";

    for(String[] row : parser.parseAll(new StringReader(input))){
        System.out.println(Arrays.toString(row));
    }
}