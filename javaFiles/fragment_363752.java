class WebMvcConfig extends WebMvcConfigurerAdapter {

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(new HandlerInterceptorAdapter() {
         Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

         @Override
         public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            if (handler instanceof HandlerMethod) {
               HandlerMethod handlerMethod = (HandlerMethod) handler;
               Method method = handlerMethod.getMethod();
               logger.info("{} - {} - method '{}' on controller '{}'",
                     request.getMethod(), request.getRequestURI(), method.getName(),
                     handlerMethod.getBean().getClass()
               );
            }
            return true;
         }
      });
   }
}