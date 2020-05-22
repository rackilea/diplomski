public class MasterModel {
    private String test;
    @ServerTimestamp
    private Date date;

    public MasterModel() {}

    public MasterModel(String test) { this.test = test; }

    public String getTest() { return test; }

    public Date getDate() { return date; }
}