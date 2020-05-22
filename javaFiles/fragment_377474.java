getApplicationContext().getBean(beanName);

package br.com.ar.web.servlet.handler;

public class CustomeHandlerMapping extends WebApplicationObjectSupport implements HandlerMapping, Ordered {

    private static final String CUSTOM_HANDLER_ADAPTER_NAME = "CUSTOM_HANDLER_ADAPTER_NAME";

    /**
      * Bind each URL path-CustomController bean name
      */
    private final Map handlerMap = new LinkedHashMap();

    /**
      * Ordered interface will make sure your HandlerMapping should be intercepted BEFORE or AFTER DefaultAnnotationHandlerMapping
      */
    public final void setOrder(int order) {
        this.order = order;
    }

    public final int getOrder() {
        return this.order;
    }

    /**
      * HandlerMapping interface method
      */
    public final HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        String url = extractUrl(request);

        if(handlerMap.get(url) == null) {
            /**
              * Because Spring 3.0 controller is stateful
              * Let's just store CustomController class (Not an instance) in ApplicationContext
              *
              * Or use a FactoryBean to retrieve your CustomController
              */
            handlerMap.put(url, getApplicationContext().getBean(beanName));
        }

        /**
          * instantiateClass needs no-arg constructor
          */
        Object handler = BeanUtils.instantiateClass(handlerMap.get(url));

        return new HandlerExecutionChain(handler);
    }

    private String extractUrl(HttpServletRequest request) {
        /**
          * Here goes code needed To retrieve URL path from request
          *
          * Take a look at AntPathMatcher, UrlPathHelper and PathMatcher
          *
          * It can be useful To see AbstractUrlHandlerMapping.getHandlerInternal method
          */ 
    }

}