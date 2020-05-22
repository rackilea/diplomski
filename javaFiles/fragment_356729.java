private static Map<Class,Logger> loggers = new HashMap<Class,Logger>();
....
public Logger getLogger ()
{
    Logger logger = null;
    if (BasicDAO.loggers.containsKey(this.getClass())) {
        logger = BasicDAO.loggers.get(this.getClass());
    } else {
        logger = LoggerFactory.getLogger(this.getClass());
        BasicDAO.loggers.put (this.getClass(), logger);
    }
    return logger;
}