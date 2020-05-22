public class SimpleOperation {
    private String operation;
    @JsonProperty("include-runtime")
    private boolean includeRuntime;
    public boolean recursive;
    private List<String> address;

    public SimpleOperation(String operation, boolean includeRuntime, 
                          boolean recursive, String... address) {
        this.operation = operation;
        this.includeRuntime = includeRuntime;
        this.address = Arrays.asList(address);
    }

    // getters and setters.
}