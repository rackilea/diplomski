I often use property file + enum combination. Here is an example:

public enum Constants {
    PROP1,
    PROP2;

    private static final String PATH            = "/constants.properties";

    private static final Logger logger          = LoggerFactory.getLogger(Constants.class);

    private static Properties   properties;

    private String          value;

    private void init() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(Constants.class.getResourceAsStream(PATH));
            }
            catch (Exception e) {
                logger.error("Unable to load " + PATH + " file from classpath.", e);
                System.exit(1);
            }
        }
        value = (String) properties.get(this.toString());
    }

    public String getValue() {
        if (value == null) {
            init();
        }
        return value;
    }

}
Now you also need a property file (I ofter place it in src, so it is packaged into JAR), with properties just as you used in enum. For example:

constants.properties:

#This is property file...
PROP1=some text
PROP2=some other text
Now I very often use static import in classes where I want to use my constants:

import static com.some.package.Constants.*;
And an example usage

System.out.println(PROP1);

Source:http://stackoverflow.com/questions/4908973/java-property-file-as-enum