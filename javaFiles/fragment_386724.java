public class Contact
{
    private String userId;
    private String userName;
    private String status;

    public Contact() {
         userId="";
         userName="";
         status="";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Contact{" + "userId=" + userId + ", userName=" + userName + ", status=" + status + '}';
    }

}