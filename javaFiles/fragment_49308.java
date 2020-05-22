Options options = new Options();

options.addOption("b", true, "some message");

String[] myArgs = new String[]{"-b","2", "file.txt"};
CommandLineParser commandParser = new GnuParser();

CommandLine commandline = commandParser.parse(options, myArgs, false);

System.out.println(Arrays.toString(commandline.getArgs()));