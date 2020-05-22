public static final Option job1;

static {
    OptionBuilder.hasArg(false);
    OptionBuilder.isRequired(false)
    OptionBuilder.withDescription("description of job1")
    job1 = OptionBuilder.create(JOB1);
}