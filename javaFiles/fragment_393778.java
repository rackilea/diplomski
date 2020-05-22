import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="bbean")
@SessionScoped
public class MyBean {

    private boolean dataTableRendered;
    private boolean linksRendered;
    private List<User> users;
    private List<String> links;

    public MyBean() {

    }

    @PostConstruct
    public void init(){
        try{
            users = new ArrayList<User>();
            links = new ArrayList<String>();
            dataTableRendered = new Boolean(true);
            linksRendered = new Boolean(true);
            for(int i=0; i<5; i++){
                users.add(new User(i,"User: XYZ-"+i));
            }

            for(int i=0; i<3; i++){
                links.add("http://www.abc-"+i+".tld");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }   

    public final void removeUser(final User selectedUser){
        if( selectedUser == null ){
            return;
        }
        for(User u: this.users){
            if( u.getId() == selectedUser.getId() ){
                users.remove(u);
                break;
            }
        }
        this.setLinksRendered(false);       
    }   

    public boolean isDataTableRendered() {
        return dataTableRendered;
    }
    public void setDataTableRendered(boolean dataTableRendered) {
        this.dataTableRendered = dataTableRendered;
    }
    public boolean isLinksRendered() {
        return linksRendered;
    }
    public void setLinksRendered(boolean linksRendered) {
        this.linksRendered = linksRendered;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<String> getLinks() {
        return links;
    }
    public void setLinks(List<String> links) {
        this.links = links;
    }

}