@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private Logger logger;

  @AroundInvoke
  public Object logMethodCall(InvocationContext invocationContext) throws Exception {

        logger.info("Entering method: "
          + invocationContext.getMethod().getName() + " in class "
          + invocationContext.getMethod().getDeclaringClass().getName());

        Object ret = invocationContext.proceed();

        logger.info("Left method: "
          + invocationContext.getMethod().getName() + " in class "
          + invocationContext.getMethod().getDeclaringClass().getName());

        return ret;
  }
}