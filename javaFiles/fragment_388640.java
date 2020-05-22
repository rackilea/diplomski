Option fizzOpt = OptionBuilder
        .withArgName("Fizz")
        .withLongOpt("fizz")
        .hasArg()
        .withDescription("The Fizz Option")
        .create("f");

cmdLineOpts.addOption(fizzOpt);
cmdLineOpts.addOption("b", true, "The Buzz Option");