@Aspect
@Configuration
public class ErrorInterceptor {
    @AfterThrowing(pointcut = "execution(* net.asifhossain.*.*(..))", throwing = "ex")
    public void errorInterceptor(Exception ex) {

        ex.printStackTrace();
    }
}