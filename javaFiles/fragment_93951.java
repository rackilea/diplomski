@Autowired(required = false)
    private FileCompressor fileCompressor;

    @Bean
    public RolloverTask rolloverTaskWithCompressor(final IntervalCalculator intervalCalculator, final FileCompressor fileCompressor) {
        return new RolloverTask(intervalCalculator, fileCompressor);
   }