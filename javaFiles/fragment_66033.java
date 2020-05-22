public class CacheInterceptor implements Interceptor {

private static final long serialVersionUID = 1L;

@Override
public void destroy() {}

@Override
public void init() {}

@Override
public String intercept(ActionInvocation invoication) throws Exception {
    HttpServletRessponse response = ServletActionContext.getResponse();
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "-1");
    return invoication.invoke();
}

}