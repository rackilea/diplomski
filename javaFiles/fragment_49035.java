options.addOption(hostOption);
    options.addOption(portOption);
    options.addOption(serviceNameOption);
    options.addOption(helpOption); // <-- must also be here to avoid exception

    try {
        if (checkForHelp(args)) {
            HelpFormatter fmt = new HelpFormatter();
            fmt.printHelp("Help", options);
            return;
        }

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);


        if (cmd.hasOption("host")) {
            host = cmd.getOptionValue("host");
            System.out.println(host); // gets in here but prints null
        }
        if (cmd.hasOption("port")) {
            port = ((Number) cmd.getParsedOptionValue("port")).intValue();
            System.out.println(port); // gets in here but throws a null
                                      // pointer exception

        }
        if (cmd.hasOption("service_name")) {
            serviceName = cmd.getOptionValue("service_name");
            System.out.println(serviceName); // gets in here but prints null
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }