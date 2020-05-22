@Bean
  public Job job() {
    LOGGER.info("STARTING BATCH JOB");
    return jobs.get("job")
        .incrementer(new RunIdIncrementer())
        .start(taskletStep())
        .on("a")
            .to(step1a)
            .next(step2)
        .from(taskletStep())            
        .on("b")
            .to(step2)
        .from(taskletStep()) 
        .on("c")
            .to(step2)
        .from(taskletStep()) 
        .on("d")
            .to(step1b)
            .next(step2)
        .end()
        .build();
  }