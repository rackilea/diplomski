@Around("execution(* org.springframework.jdbc.core.JdbcOperations.*(String, ..))")
public Object log(final ProceedingJoinPoint jp) throws Throwable {

    Object[] methodArgs = jp.getArgs(), sqlArgs = null;
    CustomUser customUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    methodArgs[0] = new String ("SELECT * FROM (" + methodArgs[0] + 
            ") AS domain_object WHERE (ktn = "+ customUser.getKtn() +") OR (ktn is NULL)");
    return jp.proceed(methodArgs);