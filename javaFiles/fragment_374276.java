@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface BehindSomething{
}

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
@Component
public class IsBehindSomethingHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(RemoteAddress.class) != null
                && methodParameter.getParameterType().equals(Boolean.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        final String ipAddress = nativeWebRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress =(((ServletWebRequest) nativeWebRequest).getRequest()).getRemoteAddr();
        }

        return ipAddress.equals("something_here");
    }
}

@RequestMapping(value = "testOperation", method = RequestMethod.GET)
public Map<String, String> testOperation(@BehindSomething Boolean behindSomething) {
       final Map<String, String> model = new LinkedHashMap<String, String>();

       if(behindSomething) {
           // then load testOperation jsp page
       } else {
           // otherwise load some error jsp page
       }

       return model;
}