@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MyHealth {

    private Map<String, Object> details;

    @JsonAnyGetter
    public Map<String, Object> getDetails() {
        return this.details;
    }
}