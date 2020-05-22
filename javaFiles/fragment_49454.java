@Bean
public Step step1() throws Exception {
    log.info("!!!  step1 !!");

    return this.stepBuilderFactory.get("step1")
            .<Position, Position> chunk(100)
            .reader(read())
            .processor(  (ItemProcessor) asyncItemProcessor() )
            .writer( asyncItemWriter() )
            .allowStartIfComplete(true)
            .build();
}