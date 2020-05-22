@Component
@Aspect
public class MyServiceAspect { 
    @Before("execution(* <packages>.MyService.doSomething())")
    public void beforeDoSomething() {
        ThreadContext.put("key", "value");
    }

    @After("execution(* <packages>.MyService.doSomething())")
    public void afterDoSomething() {
        ThreadContext.clearAll(); 
    }
}