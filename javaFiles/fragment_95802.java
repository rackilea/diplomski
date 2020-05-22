public class Main {
    private static final String FILE_NAME = "i18ned.properties";
    private File propertiesFile;
    private Properties properties;

    public Main() {
        properties = new Properties();
        propertiesFile = new File(FILE_NAME);
        if (propertiesFile.exists()) {
            try {
                properties.load(new BufferedReader(new FileReader(
                        propertiesFile)));
            } catch (FileNotFoundException e) {
                // not likely, but should be logged either way
            } catch (IOException e) {
                // logger should be used instead
                e.printStackTrace();
            }
        }
    }

    public void saveProperties() {
        try {
            properties
                    .store(new BufferedWriter(new FileWriter(propertiesFile)), "");
        } catch (IOException e) {
            // oops, use logger instead
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.storeSome();
        main.readSome();
    }

    private void readSome() {
        String highAsciiKey = "żółć";
        String value = properties.getProperty(highAsciiKey);
        System.out.println(value);
    }

    private void storeSome() {
        String highAsciiKey = "żółć";
        String highAsciiValue = "łąkę";
        properties.setProperty(highAsciiKey, highAsciiValue);
        saveProperties();
    }

}