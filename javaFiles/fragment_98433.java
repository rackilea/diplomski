public static final String json = "{\"a.b\": 1,\"a.c.d\": 2}";
public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    HelperBean bean = mapper.readValue(json, HelperBean.class);
    System.out.println(mapper.writeValueAsString(bean)); 
    // result: {"a":{"b":1,"c":{"d":2}}}
}
public static class HelperBean{
    @JsonIgnore
    private Map<String, Object> data = new TreeMap<>();

    @JsonAnySetter
    public void setDays(String key, Object value){
        String[] parts = key.split("\\.");
        Map<String, Object> currMap  = data;
        for (int i = 0; i< parts.length; i++){
            String part = parts[i];
            Object subMap  = currMap.get(part);
            if (i == parts.length - 1) // last node
                currMap.put(part, value);
            else if(subMap == null){ // new node
                subMap = new TreeMap<>();
                currMap.put(part, subMap);
                currMap = (Map<String, Object>) subMap;
            }else if (subMap instanceof Map){ // existing node
                currMap.put(part, subMap);
                currMap = (Map<String, Object>) subMap;
            } else { // node conflict
                // handle exception when a.b = 1 and a.b.c = 1
            }
        }
    }
    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }
}