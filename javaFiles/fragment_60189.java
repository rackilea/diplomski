public class MyAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest request;  // Setter
    private List<Object> myList;         // Getter

    public String execute(){
        myList = // load the list here

        String acceptHeader = request.getHeader("Accept");
        if (acceptHeader != null && acceptHeader.equals("application/json"){
            return "json"; // mapped to a JSON result
        } 
        return SUCCESS; // mapped to a dispatcher result
    }

}