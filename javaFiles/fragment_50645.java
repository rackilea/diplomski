CommandLineParser cmdLineParser = new PosixParser();

Options options = new Options();
options.addOption(OptionBuilder.withLongOpt("integer-option")
                      .withDescription("description")
                      .withType(Number.class)
                      .hasArg()
                      .withArgName("argname")
                      .create());

try {
    CommandLine cmdLine = cmdLineParser.parse(options, args);

    int value = 0; // initialize to some meaningful default value
    if (cmdLine.hasOption("integer-option")) {
        value = ((Number)cmdLine.getParsedOptionValue("integer-option")).intValue();
    }

    System.out.println(value);
} catch (ParseException e) {
    e.printStackTrace();
}