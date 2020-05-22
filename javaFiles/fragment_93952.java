@Bean
    @ConditionalOnProperty(prefix = "file.rollover.sink", name = "compress", havingValue = "no", matchIfMissing = false)
    public RolloverTask rolloverTask(IntervalCalculator intervalCalculator) {
        return new RolloverTask(intervalCalculator, null);
    }

    @Bean
    @ConditionalOnProperty(prefix = "file.rollover.sink", name = "compress", havingValue = "yes", matchIfMissing = true)
    public RolloverTask rolloverTaskWithCompressor(final IntervalCalculator intervalCalculator, final FileCompressor fileCompressor) {
        return new RolloverTask(intervalCalculator, fileCompressor);
   }