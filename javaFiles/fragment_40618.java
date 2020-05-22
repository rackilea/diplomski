import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(DispatcherServlet.HANDLER_EXCEPTION_RESOLVER_BEAN_NAME)
public class GenericHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        ModelAndView mav = new ModelAndView("error");

        if (e instanceof MyException) {
            MyException myException = (MyException) e;
            String code = myException.getCode();

            // could set the HTTP Status code
            response.setStatus(HttpServletResponse.XXX);

            // and add to the model
            mav.addObject("code", code);
        } // catch other Exception types and convert into your error page if required

        return mav;
    }
}