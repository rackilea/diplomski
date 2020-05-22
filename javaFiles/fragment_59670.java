import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class MyBean {

    private CopyMetadata copy;
    private String known;
    private Map<String, Object> others = new HashMap<>();

    public CopyMetadata getCopy() {
        return copy;
    }

    public void setCopy(CopyMetadata copy) {
        this.copy = copy;
    }

    public String getKnown() {
        return known;
    }

    public void setKnown(String known) {
        this.known = known;
    }

    public Map<String, Object> getOthers() {
        return others;
    }

    public void setOthers(Map<String, Object> others) {
        this.others = others;
    }

    @JsonAnyGetter
    public Map<String, Object> getUnknownFields() {
        return others;
    }

    @JsonAnySetter
    public void setUnknownFields(String name, Object value) {
        others.put(name, value);
    }

}