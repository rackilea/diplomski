@Bean
    public Step step() {
        return stepBuilderFactory.get("step")
            .<COR_ACC_ACCOUNT, Account>chunk(10)
            .reader((ItemReader<COR_ACC_ACCOUNT>) itemDictionary.getReader(AccountReader.class))
            .processor(accountProcessor)
            .writer(new JsonWriter<>())
            .build();
    }