public class jsonHandler
    {
    private RestResponseStructure restResponse;
    }

public class RestResponseStructure
    {
    private List<String> messages;
    private List<CountryRecord> results;
    }

public class CountryRecord {
    private String name;
    private String alpha2_code;
    private String alpha3_code;
}