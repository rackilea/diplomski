public class DroolsTest {

  private static KieSession kSession;  
  private DroolsTest instance;

  private DroolsTest(){
    if(null == instance){
      // load up the knowledge base
      KieServices ks = KieServices.Factory.get();
      KieContainer kContainer = ks.getKieClasspathContainer();
      kSession = kContainer.newKieSession("ksession-rules");
    }
  }

  public static DroolsTest getInstance(){
    if(null = instance){
      instance = new DroolsTest();
    }
  }

  public static void fire(Object input) {
    kSession.insert(input);
    kSession.fireAllRules();
  }
}