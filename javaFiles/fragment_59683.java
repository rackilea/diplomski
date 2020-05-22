@ConfigurationProperties(prefix="myconfig")
public class StorageServiceProperties {
    private String defaultSize;
    // getters and setters

    public Long determineDefaultSizeInBytes() {
        // parsing logic
    }

}