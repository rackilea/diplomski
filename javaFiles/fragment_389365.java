@Bean(name = "myWriter")
public FlatFileItemWriter<Customer> bondEdgeFlatFileItemWriter() {
    BeanWrapperFieldExtractor<Customer> fieldExtractor = new BeanWrapperFieldExtractor<>();
    fieldExtractor.setNames(new String[] {"customerId", "customerName" });
    DelimitedLineAggregator<Customer> lineAggregator = new DelimitedLineAggregator<>();
    lineAggregator.setDelimiter("");
    lineAggregator.setFieldExtractor(fieldExtractor);

    return new FlatFileItemWriterBuilder<Customer>()
            .name("myWriter")
            .resource(new FileSystemResource("customers.txt"))
            .lineAggregator(lineAggregator)
            .build();
}