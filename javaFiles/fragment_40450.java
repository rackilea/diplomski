import org.apache.log4j.Logger;

public class MyService {

    public UserAccount save(UserAccount dataObject) {
        logger.debug(dataObject.toString());

        return dao.save(dataObject);

    }

    private static Logger logger = Logger.getLogger(MyService.class);

}