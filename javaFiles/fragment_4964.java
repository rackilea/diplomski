public class ClassA{

     private final Logger LOGGER = Logger.getLogger(ClassA.class);
     static{         
        LOGGER.addAppender(LogConfig.init(LOGGER));    
     }

     some code...
  }