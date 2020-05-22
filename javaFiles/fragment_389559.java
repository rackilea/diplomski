import org.slf4j.Logger;

public class LoggyLoo
{
    public static void logZoreInfo(
        final Logger logger,
        final String message)
    {
        System.out.println(message);
        logger.info(message);
    }
}