public class MyBean {
    private String status;
    private String name;
 
    @JsonProperty("SERVICE_ID")
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
 
    @JsonProperty("SERVICE_ID")
    public String getServiceId() {
        return serviceId;
    }

    @JsonProperty("STATUS")
    public void setStatus(String status) {
        this.status = status;
    }
 
    @JsonProperty("STATUS")
    public String getStatus() {
        return status;
    }
}