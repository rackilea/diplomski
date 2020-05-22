public class SecondAction implements SessionAware {

    private Map<String,Object> session;
    public void setSession(Map<String,Object> session){ 
        this.session = session;
    }

    public String execute(){
        System.out.println(session.get("uname"));
        return SUCCESS;
    }
}