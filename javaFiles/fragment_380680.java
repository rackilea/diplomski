import static org.assertj.core.api.Assertions.assertThat;

// ...

assertThat(reporters).extracting("class").contains(
    Slf4jReporter.class,
    GraphiteReporter.class,
    CloudWatchReporter.class
);