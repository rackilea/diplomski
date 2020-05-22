public class CustomHttpServletRequestWrapper implements HttpServletRequest{
       public CustomHttpServletRequestWrapper(HttpServletRequest request){
            super(request);
       }

       public String getHeader(String name){
            if(name.equals("AUTH-HEADER"){
                  //get the original request
                  HttpServletRequest request = (HttpServletRequest)getRequest();
                   //now get it from the original request and return
            }else{
                  return request.getHeader(name);
             }
       }

      //  TODO override getHeaderNames()
}