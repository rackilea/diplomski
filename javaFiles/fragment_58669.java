public class XMLLogger extends LoggerDecorator {
    public XMLLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String msg) {
        logger.log(msg);
        System.out.println("<?xml version="1.0"?><message>XML Logger" + msg);
        //Generate the xml file
    }
}