import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.text.MessageFormat;

public class ConfigurationTest {


    public static void main(String[] args) throws ConfigurationException {
        Configuration config = new PropertiesConfiguration("config.properties");

        String stringFormat = String.format(config.getString("some.message.printf"), "Thomas", "Andrew");
        // 1 String format
        System.out.println(stringFormat);
        // 2 Message Format
        System.out.println(MessageFormat.format(config.getString("some.message.point.numbers"), "Thomas", "Hello"));
    }
}