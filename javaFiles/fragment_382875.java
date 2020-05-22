@Bean
    public Step masterStep(@Value("#{proccessFilesStep}") Step readFilesStep) {

        return  stepBuilders.get("masterStep")
                .partitioner(readFilesStep)
                .partitioner("proccessFilesStep", partitioner())
                .taskExecutor(taskExecutor())
                .build();

    }