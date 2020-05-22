public class Main {

   public static void main(String[] args) {
     Logger logger = (Logger) LoggerFactory.getLogger("abc.xyz");

     LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
     FileAppender<LoggingEvent> fileAppender =
                       (FileAppender<LoggingEvent>) logger.getAppender("file");
     if(fileAppender != null) {
       fileAppender.stop();
       fileAppender.setFile("new.log");
       PatternLayout pl = new PatternLayout();
       pl.setPattern("%d %5p %t [%c:%L] %m%n)");
       pl.setContext(lc);
       pl.start();
       fileAppender.setLayout(pl);
       fileAppender.setContext(lc);
       fileAppender.start();
     }
     ... etc    
   }
}