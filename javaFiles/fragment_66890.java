public class FirstAction implements SessionAware {

    private Map<String,Object> session;
    public void setSession(Map<String,Object> session){ 
        this.session = session;
    }

    private String username; /* with Getter and Setter */

    public String execute(){
        session.put("uname", username);
        return SUCCESS;
    }
}