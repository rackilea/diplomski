@Component
public class WebInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.error("WebInterceptor prehandle is now logged");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.error("WebInterceptor after completion is now logged");
        super.afterCompletion(request, response, handler, ex);
    }
}