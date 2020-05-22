@JsonIgnoreProperties(ignoreUnknown = true)
class StatusErrors {
    private String status;
    private Object errors;
    public Map<String, String> getErrorsMap() {
        if (this.errors instanceof Map) {
            return (Map)this.errors;
        }
        return null;
    }
....