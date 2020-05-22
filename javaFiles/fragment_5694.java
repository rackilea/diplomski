@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {
    private int id;
    private String beanName;
    private Role role;


    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBeanName() {
        return beanName;
    }
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}