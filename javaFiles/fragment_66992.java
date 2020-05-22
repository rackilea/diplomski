public class App {

 public static void main(String[] args) {

  ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

  Logger logger = ctx.getBean(Logger.class);
  logger.writeConsole("Hello there");
  logger.writeFile("Hi again");
 }
}