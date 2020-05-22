public class Main {

    static Logger logger;

    public static void main(String[] args) {
        logger = Logger.getLogger("Main");
        FileHandler fh;

        File lf = new File("data" + File.separator + "logs" + File.separator + "chatlog.log");

        if (!(lf.getParentFile().exists())){
            lf.getParentFile().mkdirs();
        }


        try {
            fh = new FileHandler(lf.getCanonicalPath(), 8096, 1, true);
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);
            SimpleFormatter fmt = new SimpleFormatter();
            fh.setFormatter(fmt);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("foo");
        logger.info("bar");
    }
}