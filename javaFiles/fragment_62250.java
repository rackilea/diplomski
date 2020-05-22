public class LoggerInterceptor extends HandlerInterceptorAdapter {    
    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("pre hangle URI: " + request.getRequestURI());

        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("post hangle URI: " + request.getRequestURI());

        super.afterCompletion(request, response, handler, ex);
    }    
}