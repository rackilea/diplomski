import java.util.Map;

public class DatabaseEntry {
    private String action;
    private Map<String, Map<String,String>> data;

    public DatabaseEntry() {

    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }
}