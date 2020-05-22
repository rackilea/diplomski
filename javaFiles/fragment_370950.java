public class ALL_USERS {
    private String name, SonyTV;
    private long Date;

    public ALL_USERS() {}

    public ALL_USERS(String name, String sonyTV, long date) {
        this.name = name;
        SonyTV = sonyTV;
        Date = date;
    }

    public String getName() { return mame; }
    @PropertyName("SonyTV")
    public String getSonyTV() { return SonyTV; }
    @PropertyName("Date")
    public long getDate() { return Date; }
}