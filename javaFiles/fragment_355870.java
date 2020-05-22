@Component
public class AuthFilter implements Filter {

    @Override
    public void doFilter
      ServletRequest request, 
      ServletResponse response, 
      FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        if(authenticate(req.getHeaders)){
            chain.doFilter(request, response);
        } else {
            //else logic, ie throw some exception in case authenticate returns false
        }
    }

}