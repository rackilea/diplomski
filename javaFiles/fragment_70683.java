@Bean
@StepScope
public FlatFileItemReader flatFileItemReader(@Value("#{jobParameters['inputFileName']}") String name) {
   return new FlatFileItemReaderBuilder<Foo>()
               .name("flatFileItemReader")
               .resource(new FileSystemResource(name))
               // set other properties on the reader
}