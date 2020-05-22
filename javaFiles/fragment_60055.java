import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test
{
    private final Logger logger = LogManager.getLogger(Test.class);

    public Test(String serialPortName) {
        System.out.println(logger.isInfoEnabled());
        logger.entry();
        logger.info("info! {}", serialPortName);
        logger.error("error! {}", serialPortName);
        logger.debug("debug! {}", serialPortName);
    }

    public static void main(String args[])
    {
        Test h1 = new Test("1001");
    }
}