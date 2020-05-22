public class MyAction extends ActionSupport {

    private int isJSON;                  // Setter
    private List<Object> myList;         // Getter

    public String execute(){
        myList = // load the list here

        if (isJSON==1) {
            return "json"; // mapped to a JSON result
        }
        return SUCCESS; // mapped to a dispatcher result
    }

}