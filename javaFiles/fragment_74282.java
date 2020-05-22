//there's probably a better name for this, but let's go with this for now
public class Data {
    private Map<String, Integer> attributes = new HashMap<>();

    public Integer getValue(String attribute) {
        return attributes.get(attribute); //This doesn't handle cases where
                                          //the attribute doesn't exist. Maybe
                                          //you want to return 0 for that. 
    }

    public Integer setValue(String attribute, Integer value) {
        attributes.put(attribute, value);
    } 
}