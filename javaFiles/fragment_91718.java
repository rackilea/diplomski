public class ErrorResponse {
    @JsonProperty("general_errors")
    private String generalErrors;
    private List<SpecificError> errors;

    public ErrorResponse(String generalErrors, List<SpecificError> errors) {
        this.generalErrors = generalErrors;
        this.errors = errors;
    }

    public String getGeneralErrors() {
        return generalErrors;
    }

    public List<SpecificError> getErrors() {
        return errors;
    }
}

public class SpecificError {
    private String key;
    private String value;

    public SpecificError(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}