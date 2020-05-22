public static Option helpOption = Option.builder("h")
          .longOpt("help")
          .required(false)
          .hasArg(false)
          .build();

  public static boolean checkForHelp(String[] args) throws ParseException  { 
    boolean hasHelp = false;

    Options options = new Options();


    try {
      options.addOption(helpOption);

      CommandLineParser parser = new DefaultParser();

      CommandLine cmd = parser.parse(options, args);

      if (cmd.hasOption(helpOption.getOpt())) {
          hasHelp = true;
      }

    }
    catch (ParseException e) {
      throw e;
    }

    return hasHelp;
  }