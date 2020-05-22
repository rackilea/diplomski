public class Customer {

    @SerializedName("cust_id")
    private List<String> custId;

    public List<String> getCustId() {
        return custId;
    }

    public void setCustId(List<String> custId) {
        this.custId = custId;
    }
}