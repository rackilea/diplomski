BeanListProcessor<Employee> rowProcessor = new BeanListProcessor<Employee>(Employee.class);

CsvParserSettings parserSettings = new CsvParserSettings();
parserSettings.setRowProcessor(rowProcessor);
parserSettings.setHeaderExtractionEnabled(true);

CsvParser parser = new CsvParser(parserSettings);

//And parse!
//this submits all rows parsed from the input to the BeanListProcessor
parser.parse(new FileReader(new File("/path/to/your.csv"))); 

List<Employee> beans = rowProcessor.getBeans();