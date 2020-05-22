public class DataBean{
    private UserBean user;       

    public DataBean(UserBean user) {
        this.user = user;
    }

    public String getUsernameTwo() {
        return user.getUsername(); 
    }
}