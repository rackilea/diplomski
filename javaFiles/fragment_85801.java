public class TestDTO
{
    public String regularAccessProperty;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String writeAccessProperty;
}