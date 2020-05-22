public class MasterModel {
    private String test;
    @ServerTimestamp
    private Date createdAt, updatedAt;

    public MasterModel() {}

    public MasterModel(String test) { this.test = test; }

    public String getTest() { return test; }

    public Date getCreatedAt() { return createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
}