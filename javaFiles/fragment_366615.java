@JsonValue
@Transient
public Map<String,Integer> getJsonObject(){
    HashMap<String,Integer> map = new HashMap<String,Integer>();
    map.put("id", getId());
    return map;
}