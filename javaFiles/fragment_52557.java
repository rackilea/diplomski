@Dependent //if you don't declare any scope, it's @Dependent by default
public class MyAnotherBean {
  public MyAnotherBean(InjectionPoint ip) {
    // CDI will inject InjectionPoint automatically
    ip.getMember().getDeclaringClass().getName(); 
  }
}