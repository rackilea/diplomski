public class Main {
   @Autowired
   private RunElem runelem;

   public static void main(String[] args) {
       ApplicationContext context= new ClassPathXmlApplicationContext("/META-INF/application-context.xml");
    Main mainBean = new Main();
    context.getAutowireCapableBeanFactory().autowireBean(mainBean);
    mainBean.runRun();
   }

   private void runRun(){
      runelem.runHello();
   }
 }