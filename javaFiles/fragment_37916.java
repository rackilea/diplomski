public class Message {

    private String poolName;
    private String description;

    public Message (String poolName, String description){
       this.poolName = poolName;
       this.description = description;
    }

    public User getPoolName() {
        return poolName;
    }
    public String getDescription() {
        return description;
    }
}