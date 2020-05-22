public class FilesClass {
    String FileName;
    Float Percentage;

    public FilesClass(String fileName, Float percentage) {
        FileName = fileName;
        Percentage = percentage;
    }

    public FilesClass() {
    }

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public Float getPercentage() {
        return Percentage;
    }

    public void setPercentage(Float percentage) {
        Percentage = percentage;
    }
}