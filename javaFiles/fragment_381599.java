public class JsonWrapper {
    public Embedded _embedded;
}


public class Embedded {
    public Customers customers;
}


public class Customers extends ArrayList<Foo>{ }


public class Foo{
    public int id;
    public String name;
    public String city;
}


String json = "{\"_embedded\":{\"customers\":[{\"id\":101,\"name\":\"John\",\"city\":\"Ohio\"},{\"id\":102,\"name\":\"Tom\",\"city\":\"London\"}]}}";
JsonWrapper wrapper = new Gson().fromJson(json, JsonWrapper.class);