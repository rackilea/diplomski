@Dependent //if you don't declare any scope, it's @Dependent by default
public class MyBean {
  @Inject
  InjectionPoint ip;

  public void doStuff() {
    // gives you the name of declaring class
    ip.getMember().getDeclaringClass().getName(); 
  }
}