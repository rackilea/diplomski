public class DataResponse extends Response
{
    private List<Map<String, String>> key1;
    private Key2SchemaClass key2;

    public DataResponse()
    {
    }

    public static class Key2SchemaClass
    {
         private List<Map<String, Description>> description;
    }
    public static class Description
    {
         private String description1;
         private String description2;
    }
    //getters
}