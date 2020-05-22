@Aspect
public class AopConfiguration{
...
@Around("execution(* *(..)) && @annotation(groupMembersOnly)")
  public Object around(ProceedingJoinPoint point, GroupMembersOnly groupMembersOnly) throws Throwable {

    //do something, e.g. use point.getArgs()
    //to do something with the menthod arguments

    //give control back to method
    return point.proceed();
}
}