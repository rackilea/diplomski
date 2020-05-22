import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {

    private static final Logger LOG = Logger.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library

        // shorten tag names when saved
        xstream.alias(Person.class.getSimpleName(), Person.class);
        xstream.alias(PhoneNumber.class.getSimpleName(), PhoneNumber.class);

        // create object
        Person joe = new Person("Joe", "Walnes");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));

        // serialize
        String xml = xstream.toXML(joe);

        // open file
        File configFile = new File("Config.txt");

        // write to file
        try (PrintWriter writer = new PrintWriter(configFile, "UTF-8");) {
            xml = xstream.toXML(joe);
            writer.println(xml);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        // read file
        try (Scanner scanner = new Scanner(configFile, "UTF-8");) {
            scanner.useDelimiter("\\A");
            xml = scanner.next();
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        // deserialize
        Person newJoe = (Person) xstream.fromXML(xml);

        System.out.println("Does toString return the same String? " + joe.toString().equals(newJoe.toString()));
    }
}