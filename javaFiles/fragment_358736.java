public class ChatMessage {

private Map<String, String> map = new HashMap<>();

@JsonAnyGetter
public Map<String, String> any(){
    return this.map;
}

public Map<String, String> getMap() {
    return this.map;
}

@JsonAnySetter
public void setMap(String key, String value) {
    map.put(key, value);
}

@Override
public String toString() {
    return "Map [map=" + map + "]";
}
}