import java.io.StringReader;
import java.util.*;

public class Strings {
    public static void main(String[] args) throws Exception {
        String input = "a=\"0PN5J17HBGZHT7JJ3X82\", b=\"frJIUN8DYpKDtOLCwo/yzg=\"";
        String propertiesFormat = input.replaceAll(",", "\n");
        Properties properties = new Properties();
        properties.load(new StringReader(propertiesFormat));
        System.out.println(properties);
    }
}