public class Storage{
    protected Map<String, Serializable> properties = new HashMap<>();

    public <T extends Serializable> void put(String name , T value){
        properties.put(name, value);
    }
}