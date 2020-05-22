@Aspect 
@Component 
public class AopInterseptor{

  @After("execution(* my.Service.MyService.execute(Long))") 
  public void intercept(JoinPoint joinPoint) throws Exception 
  {  
    // Do stuff 
  }

}