@Component
public class TestEnv {

  private Environment environment;

  public TestEnv(Environment environment) {
     this.environment = environment;
     printEnvs();
  }

  public void printEnvs() {
    System.out.println(environment.getActiveProfiles()[0]);
 }

}