public class MyAction extends ActionSupport {

    private List<Object> myList;          // Getter 

    public String execute(){
        doBusiness();
        return SUCCESS;
    }

    public String jsonExecute(){
        doBusiness();
        return SUCCESS;
    }

    private void doBusiness(){
        myList = // load the list here
    }    

}