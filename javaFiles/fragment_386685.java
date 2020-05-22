public class HadoopFileCreation1 {
    public final static Logger logger = Logger.getLogger(HadoopFileCreation1.class);

    public String fileName = null;
    private String log4jFile=null,configFile=null;
    static Properties prop = new Properties();

    public static void main(String[] args) {
        try {

             log4jFile = args[0];
             configFile = args[1];

            System.out.println("---------START------------");
            PropertyConfigurator.configure(log4jFile );
            HadoopFileCreation1 hfc = new HadoopFileCreation1();
            hfc.readProperty(configFile);

            hfc.writeDATFileForHadoop("PORT", getPropValues("START_TIME"));
            hfc.writeDATFileForHadoop("VLAN", getPropValues("START_TIME"));

            System.out.println("---------END------------");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }

    public void readProperty(String configFile) {
        try {
            prop = new Properties();
            String propFileName = configFile;
            File file = new File(propFileName);
            FileInputStream inputStream = new FileInputStream(file);
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}