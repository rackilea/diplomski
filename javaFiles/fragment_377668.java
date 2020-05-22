public class JCommanderExample {

    @Parameter(names = "-debug", description = "Debug mode")
    private boolean debug = false;

    @Parameter(names = "--help", help = true)
    private boolean help = false;

    public static void main(String[] args) {
        JCommanderExample jct = new JCommanderExample();
        JCommander jCommander = new JCommander(jct, args);
        jCommander.setProgramName("JCommanderExample");
        if (jct.help) {
            jCommander.usage();
            return;
        }
        System.out.println("your logic goes here");
    }
}