@Configuration
@ConfigurationProperties(prefix = "document.templates")
public class FileTypesConfig {

    private List<String> fileTypes;

    public List<String> getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(List<String> fileTypes) {
        this.fileTypes = fileTypes;
    }
}