import org.springframework.http.HttpStatus;
public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

HttpServletResponse servletResponse = ((ServletServerHttpResponse) serverHttpResponse).getServletResponse();

if(servletResponse.getStatus() == 200) {
        return createYourResponseBodyE_G_200().getBody();

 } else if(servletResponse.getStatus() == 500) {
        return createYourResponseBodyE_G_500().getBody();
 }


public ResponseEntity<Object> createYourResponseBodyE_G_200() {

        return new ResponseEntity<Object>(  "data: { \"result\":\"success\" }", HttpStatus.OK);

}

public ResponseEntity<Object> createYourResponseBodyE_G_500() {

        return new ResponseEntity<Object>(  "data: { \"error\":\"500\" }", HttpStatus.INTERNAL_SERVER_ERROR);

}