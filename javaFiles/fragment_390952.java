Options options = new Options();

    options.addOption( "M", false,"Merge files request.")
            .addOption("CP", false,"Copy files from file.");

    CommandLineParser parser = new DefaultParser();
    try {

        CommandLine cmd = parser.parse(options, args);
        if (!cmd.hasOption("M")) {
            throw new IllegalArgumentException("Must specify an input file.");
        }
        // Do something

        if (!cmd.hasOption("CP")) {
            throw new IllegalArgumentException("Must specify an input file.");
        }

       // Do something

    catch (Exception e) {
        System.out.println(e.getMEssage());
    }