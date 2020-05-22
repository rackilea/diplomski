@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyObject{
    @JsonProperty("model")
    MyModel model;
}