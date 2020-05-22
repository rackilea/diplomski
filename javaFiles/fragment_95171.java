@Path("/")
public class Resource
{
    private static final Map<Integer,String> data;
    static
    {
        myMap = new new ConcurrentHashMap<Integer,String>();
        myMap.put(1, "1");
        myMap.put(2, "2");
    }
}