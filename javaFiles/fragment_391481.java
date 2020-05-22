package models;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecurOrderJSON {

    public String id;
    public String event_type;
    public String request_id;
    public Map data;

    @Override
    public String toString() {
        return "RecurOrderJSON [id=" + id + ", event_type=" + event_type + ", request_id=" + request_id + ", data="
                + data.toString() + "]";
    }
}