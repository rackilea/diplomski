import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;

public class PropertiesReader {
    public static void main(String args[]) throws ConfigurationException, FileNotFoundException {
        File file = new File(args[0] + ".properties");

        PropertiesConfiguration config = new PropertiesConfiguration();
        PropertiesConfigurationLayout layout = new PropertiesConfigurationLayout(config);
        layout.load(new InputStreamReader(new FileInputStream(file)));

        config.setProperty("test", "testValue");
        layout.save(new FileWriter("path\\to\\properties\\file.properties", false));
    }
}