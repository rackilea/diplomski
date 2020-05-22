@Autowired
@Qualifier("jpaTrx")
PlatformTransactionManager jpaTransactionManager

 //Reader is a FlatFileItemReader, writer is CustomItemWriter.
    @Bean
    public Step step(StepBuilderFactory steps,
            MultiResourceItemReader<T> rea,
            ItemProcessor<T, T> pro,
            ItemWriter<T> wr) {
        return steps.get("step")
                //attach tx manager
                .transactionManager(jpaTransactionManager)
                .reader(rea)
                .processor(proc)
                .writer(wr)
                .build();
    }