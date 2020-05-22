package br.com.ar.web.support;

public class CustomHandlerAdapter implements HandlerAdapter {

    public boolean supports(Object handler) {
        Annotation [] annotationArray = handler.getClass().getAnnotations();

        for(Annotation annotation: annotationArray) {
           /**
             * Make sure your annotation contains @SomeController
             */
        }
    }

    /**
      * Third parameter is our CustomController
      */
    public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Method[] methods = handler.getClass().getMethods();

        /**
          * Logic To verify whether Target method fullfil request goes here
          */            

        /**
          * It can be useful To see MultiActionController.invokeNamedMethod and MultiActionController.isHandlerMethod              
          */
        method.invoke(// parameters goes here);
    }

    public long getLastModified(HttpServletRequest request, Object handler) {
        return -1;
    }
}