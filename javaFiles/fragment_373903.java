public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,ServletException {

        if(ANY CONDITION){
            //ANY POJO CLASS
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setCode(401);
            errorResponse.setMessage("Unauthorized Access");

            byte[] responseToSend = restResponseBytes(errorResponse);
            ((HttpServletResponse) response).setHeader("Content-Type", "application/json");
            ((HttpServletResponse) response).setStatus(401);
            response.getOutputStream().write(responseToSend);
            return;
        }

        //ANY OTHER BUSINESS LOGIC
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private byte[] restResponseBytes(ErrorResponse eErrorResponse) throws IOException {
        String serialized = new ObjectMapper().writeValueAsString(eErrorResponse);
        return serialized.getBytes();
    }
}