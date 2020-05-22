public class Main {
    public static void main(String[] args) {
            String currentDir = null;
        try {
            currentDir = new File(".").getCanonicalPath();
            LOG.info("Current application directory: " + currentDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String war = currentDir + "\\target\\app.war";
        String tomeeConf = currentDir + "\\src\\main\\tomee\\conf\\tomee.xml";

        // ARGUMENTS
        String[] setup = { "--path", war, "--tomeexml", tomeeConf };
        try {
            // PROGRAM:
            org.apache.tomee.embedded.Main.main(setup);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}