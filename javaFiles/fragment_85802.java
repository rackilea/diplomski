// mixin class that overrides json access annotation
public class UnitTestDTO
{
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    public String writeAccessProperty;
}