public class MyEventHandler implements ValidationEventHandler {

private static final Logger logger = Logger.getLogger(MyEventHandler.class);

@Override
public boolean handleEvent(ValidationEvent event) {

    if(event.getLocator().getObject() instanceof com.path.MyObject || 
            event.getMessage().contains("length = '0' is not facet-valid with respect to minLength '1' for type '#AnonType_name'")){
        return true;
    }
    logger.info("\nEVENT");
    logger.info("SEVERITY: " + event.getSeverity());
    logger.info("MESSAGE: " + event.getMessage());
    logger.info("LINKED EXCEPTION: " + event.getLinkedException());
    logger.info("LOCATOR");
    logger.info(" LINE NUMBER: " + event.getLocator().getLineNumber());
    logger.info(" COLUMN NUMBER: " + event.getLocator().getColumnNumber());
    logger.info(" OFFSET: " + event.getLocator().getOffset());
    logger.info(" OBJECT: " + event.getLocator().getObject());
    logger.info(" NODE: " + event.getLocator().getNode());
    logger.info(" URL: " + event.getLocator().getURL());
    return false;
}