@Root
public class Point {

    @ElementMap(entry="rssi", key="id", attribute=true, inline=true)
    private Map<String,Integer> rssiMap;

    @Attribute
    protected String id;

    public String getId() {
        return id;
    }

    public Integer getRssi(String id) {
        Integer val = rssiMap.get(id);
        if(val == null){
            return 999;
        }
        return val;
    }
}