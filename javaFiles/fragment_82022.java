@Aspect
public class ErrorInterceptor{
@AfterThrowing(pointcut = "execution(* com.mycompany.package..* (..))", throwing = "ex")
public void errorInterceptor(WidgetException ex) {
    if (logger.isDebugEnabled()) {
        logger.debug("Error Message Interceptor started");
    }

    // DO SOMETHING HERE WITH EX
    logger.debug( ex.getCause().getMessage());


    if (logger.isDebugEnabled()) {
        logger.debug("Error Message Interceptor finished.");
    }
}
}