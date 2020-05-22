class MainExecute
{
 public static void main()
 { 

  ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF\\spring\\my-spring-config.xml");
  Main main = (Main) appContext.getBean("myMainClass");

   }
}