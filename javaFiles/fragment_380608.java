@Bean
    @StepScope
    public ItemProcessor<InputVO,OutputVO> luceneIndexProcessor(@Value("#{stepExecutionContext[field1]}") String field1,@Value("#{stepExecutionContext[luceneObjects]}") SerializableLuceneObjects luceneObjects) throws Exception{
        LuceneIndexProcessor indexProcessor =new LuceneIndexProcessor(luceneObjects);
        return indexProcessor;
    }