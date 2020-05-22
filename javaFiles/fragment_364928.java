// if inner class add "static"
public class Data {
    public Map<String,String> properties;
    public List<String> missing;
}

//...
Data data = new Gson().fromJson(reader, Data.class);