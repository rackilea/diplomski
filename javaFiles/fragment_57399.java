import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClass {

    public static Logger LOGGER = LoggerFactory.getLogger(MyClass.class);

    public static void main(String[] args) {
        LOGGER.debug("Enter debug message here.");
    }

}