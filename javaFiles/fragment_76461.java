private static final Logger LOGGER = Logger.getLogger(MyClass.class.getName());

 Handler handlerObj = new ConsoleHandler();
 handlerObj.setLevel(Level.ALL);
 LOGGER.addHandler(handlerObj);
 LOGGER.setLevel(Level.ALL);
 LOGGER.setUseParentHandlers(false);