MyRowProcessor<SomeObject> processor = new MyRowProcessor<SomeObject>(SomeObject.class);

settings.setRowProcessor(processor);
settings.setHeaderExtractionEnabled(true);

CsvParser parser = new CsvParser(settings);

parser.parse(new File("/path/to/file"));

List<TestBean> beans = processor.getBeans();