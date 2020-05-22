public static boolean checkForHelp(String[] args) throws ParseException
{
    boolean hasHelp = false;

    Options options = new Options();


    try {
        options.addOption(hostOption);  //has required set
        options.addOption(portOption);
        options.addOption(serviceNameOption);
        options.addOption(helpOption);            

        // create an option group
        OptionGroup og = new OptionGroup();
        og.addOption(hostOption);
        og.addOption(portOption);
        og.addOption(serviceNameOption);
        og.addOption(helpOption);

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = parser.parse(options, args, false);

        if (cmd.hasOption(helpOption.getOpt()) || cmd.hasOption(helpOption.getLongOpt())) {
            hasHelp = true;
        }

    }
    catch (ParseException e) {
        throw e;
    }

    return hasHelp;
}