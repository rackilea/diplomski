public class Configuration {

    private static Logger LOGGER = Logger.getLogger(Configuration.class)//

    private static class HolderLazySingleton {
        private static Configuration instance = new Configuration();
    }

    private Wini ini = null;

    private Configuration() {    
        try {
            ini = new Wini(new File(Constants.PATH));    
        } catch (Exception e) {
            LOGGER.error("Exception during init of Configuration",e);
        }
    }

    public static Configuration getInstance() {
        return HolderLazySingleton.instance;
    }

    public String getConfig(String xSectionName, String xFieldValue) {

        String readValue = null;

        if (ini.get(xSectionName, xFieldValue) != null) {
            readValue = ini.get(xSectionName, xFieldValue);
        } else {
            // TODO: What should happen
        }
        return readValue;
    }

    public void setConfig(String xSectionName, String xFieldValue, String xValue) {

        System.out.println("Section: " + xSectionName);
        System.out.println("Field:   " + xFieldValue);
        System.out.println("Value:   " + xValue + "\n\n");

        try {
            ini.put(xSectionName, xFieldValue, xValue);
            ini.store();
        } catch (Exception e1) {
            LOGGER.error(xValue + " could not be stored.", e1);         
        }
    }
}