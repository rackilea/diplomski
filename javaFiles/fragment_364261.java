@Aspect
@Component
public class InterceptorDemo {

  @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
  public void requestMapping() {
  }
  @Pointcut("@annotation(you.package.RequestMenuMapping)")
  public void requestMenuMapping() {
  }


  @AfterReturning("requestMapping() && equestMenuMapping()")
  public void checkServer(JoinPoint joinPoint,Object returnObj) throws Throwable {
      Object[] args = joinPoint.getArgs();
      Model m = (Model)args[0];
      // use joinPoint get class or methd...
  }
}