@Bean
public Step step(StepBuilderFactory stepBuilderFactory, @Qualifier("itemReader") ItemReader<SomeItem> reader) {
    return stepBuilderFactory.get("step")
            .chunk(chunkSize)
              .reader(reader)
              .processor(processor)
              .writer(writer)
              .listener(writerListener)
            .build();
}