@DynamoDBTable(tableName = "nested-data-test")
public class NestedData {

    private String desc;
    private Map<String, String> conf;

    @DynamoDBHashKey
    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }

    @DynamoDBAttribute
    public Map<String, String> getConf() { return conf; }
    public void setConf(Map<String, String> conf) { this.conf = conf; }
}