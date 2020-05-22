@Autowired
    JpaTransactionManager trxm;

    public Step processingStep(Resource[] resources) throws IOException {
        return stepBuilderFactory.get("Process CSV File")
                .transactionManager(trxm)
                .<DataRecord, DataRecord>chunk(1000)
                .reader(multiResourceItemReader()).writer(writer).build();
    }