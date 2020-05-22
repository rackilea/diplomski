@ManagedBean @RequestScoped
public class NameUpdater {
    @ManagedProperty("#{param.name}") private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ManagedProperty("#{user}") private User user;
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @PostConstruct public void init() {
        if(name != null) user.setName(name);
    }
}