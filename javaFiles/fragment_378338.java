@Around(
    value = "execution(* com.mycompany.services.*.*(..)) && @annotation(tx)",
    argNames = "tx") 
public Object myMethod(ProceedingJoinPoint pjp, Transactional tx) 
    throws Throwable {
    ...
}