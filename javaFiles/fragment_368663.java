@ConfigurationProperties(prefix = "sdk")
class SdkProperties {

    private boolean enabled;
    private String apiKey;

    @ConstructorBinding
    public SdkProperties(boolean enabled, String apiKey) {
        this.enabled = enabled;
        this.apiKey = apiKey;
        // direct validation in the constructor
        boolean apiKeyNullOrEmpty = null == apiKey || apiKey.isEmpty();
        Assert.isTrue(!enabled || !apiKeyNullOrEmpty, "When SDK is enabled, a SDK-api key is mandatory!");
    }

    public boolean isEnabled() {  return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
    public String getApiKey() {return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }
}