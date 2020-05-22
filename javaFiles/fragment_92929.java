public class MyRequest extends HttpServletRequestWrapper {

    public MyRequest(HttpServletRequest request) {
        super(request);
    }

    @Override    
    public String getContextPath() {
        return "a different context path"; // TODO: implement accordingly.
    }

}