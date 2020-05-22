public static void main(String[] args) {

   Options options = new Options();

   try {
      options.addOption(OptionBuilder.withArgName("help").hasArgs(0).withDescription("Prints this help message.").isRequired(false).create("h"));
      options.addOption(OptionBuilder.withArgName("debug logging").hasArgs(0).withDescription("Enable debug logging").isRequired(false).create("1"));

      CommandLineParser parser = new PosixParser();
      CommandLine cmd = parser.parse(options, args);

      if (cmd.hasOption("h")) {
         new HelpFormatter().printHelp(400, "load_page_spool.sh", "OPTIONS", options, "Loads crawl data from pages pool, updating FRONTIER, HISTORY and PageTable", true);
         return;
      }

      ....

   } catch (MissingOptionException e) {
       HelpFormatter formatter = new HelpFormatter();
       formatter.printHelp("LoadPageSpool", options);
   }


}