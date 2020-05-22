return jobBuilderFactory.get("job")
    .incrementer(new RunIdIncrementer())
    .listener(jobListener())
    .flow(step1())
    .next(step2())
    .next(encrypt()).on("CONTINUE")
    .to(step2())
    .next(encrypt()).on("COMPLETED")
    .end().end().build();