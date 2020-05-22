BeanListProcessor<TestBean> rowProcessor = new BeanListProcessor<TestBean>(TestBean.class);

CsvParserSettings parserSettings = new CsvParserSettings();
parserSettings.setRowProcessor(rowProcessor);
parserSettings.setHeaderExtractionEnabled(true);

CsvParser parser = new CsvParser(parserSettings);

//And parse!
//this submits all rows parsed from the input to the BeanListProcessor
parser.parse(new FileReader(new File("/examples/bean_test.csv"))); 

List<TestBean> beans = rowProcessor.getBeans();