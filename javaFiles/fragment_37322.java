@Aspect
public class InterceptButtonMethods {
  @Before("execution(* Button.focus())")
  public void beforeInvoke() {
    System.out.println("Button.focus invoked");
    incrementFocusCount();
  }
}