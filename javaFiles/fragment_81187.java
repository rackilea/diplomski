public class LoggingMethodInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(LoggingMethodInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod method = (HandlerMethod) handler;

        GetMapping mapping = method.getMethodAnnotation(GetMapping.class);

        log.info("URL is {}", Arrays.toString(mapping.value()));

        return true;
    }
}