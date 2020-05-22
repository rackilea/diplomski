public class Test {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption(OptionBuilder.withLongOpt("sources").withDescription("path to sources").hasArgs().withArgName("PATHS").create());

        CommandLineParser parser = new GnuParser();
        CommandLine line = null;

        try {
            line = parser.parse(options, args, true);
        } catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }

        System.out.println(Arrays.toString(line.getOptionValues("sources")));
    }
}