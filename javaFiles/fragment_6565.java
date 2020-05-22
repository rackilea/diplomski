@Bean
public FlatFileItemReader<Pojo> flatFileItemReader() {
    return new FlatFileItemReaderBuilder<Pojo>()
            .name("itemReader")
            .resource(new FileSystemResource("/path/to/flat/file"))
            .targetType(Pojo.class)
            .delimited()
            .delimiter(";")
            .names("column1", "column2")
            .build();
}