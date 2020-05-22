public class ALL_USERS {
    private String name, sonyTV;
    private long date;

    public ALL_USERS() {}

    public ALL_USERS(String name, String sonyTV, long date) {
        this.name = name;
        this.sonyTV = sonyTV;
        this.date = date;
    }

    public String getName() { return name; }
    public String getSonyTV() { return sonyTV; }
    public long getDate() { return date; }
}