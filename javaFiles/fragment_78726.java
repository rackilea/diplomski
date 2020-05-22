@Bean
public Step step() {
    return stepBuilderFactory.get("step").<Object, Object> chunk(1).reader(dummyReader())
            .processor(logItemProcessor()).writer(logItemWriter()).build();
}

@Bean
public Step step2() {
    return stepBuilderFactory.get("step2").<Object, Object> chunk(1).reader(secondReader())
            .processor(logItemProcessor()).writer(logItemWriter()).listener(listener()).build();
}