public class SpringContextLoader {
   private static ApplicationContext ctx = null;
   public static void init() {
       if (ctx == null) {
          ctx = ClassPathXmlApplicationContext("classpath:/applicatonContext.xml");
       }
   }
}