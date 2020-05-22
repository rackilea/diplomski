@Test
public void testInvalidRows() throws IOException {

    String input = "column1,column2,column3\n" +
            "has,three,columns\n" +
            "only,two\n" +
            "one\n" +
            "three,columns,again\n" +
            "one,too,many,columns";

    CsvPreference preference = CsvPreference.EXCEL_PREFERENCE;
    int expectedColumns = 3;
    SkipBadColumnCountTokenizer tokenizer = new SkipBadColumnCountTokenizer(
        new StringReader(input), preference, expectedColumns);

    try (ICsvBeanReader beanReader = new CsvBeanReader(tokenizer, preference)) {
        String[] header = beanReader.getHeader(true);
        TestBean bean;
        while ((bean = beanReader.read(TestBean.class, header)) != null){
            System.out.println(bean);
        }
        System.out.println(String.format("Ignored lines: %s", tokenizer.getIgnoredLines()));
    }

}