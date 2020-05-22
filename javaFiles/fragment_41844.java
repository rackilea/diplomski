public class TestEndPoint
{
    @Inject ConfigurationService configurationService;

    private String jsonProperties = null;

    //left out other annotations
    public String printMessage()
    {
        if (jsonProperties == null)
            jsonProperties = configurationService.getPropertiesJSONString()

        return jsonProperties;
    }
}