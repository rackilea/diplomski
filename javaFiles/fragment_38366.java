import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class NoContentControllerAdvice implements ResponseBodyAdvice<Void> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if(returnType.getParameterType().isAssignableFrom(void.class)) {
            return true;
        }

        return false;
    }



    @Override
    public Void beforeBodyWrite(Void body, MethodParameter returnType, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> converterType, ServerHttpRequest request, ServerHttpResponse response) {

        if(returnType.getParameterType().isAssignableFrom(void.class)) {
            response.setStatusCode(HttpStatus.NO_CONTENT);
        }

        return body;
    }
}