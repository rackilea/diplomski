public class ContainingClass {

    private FileAccessor fileAccessor;

    // this constructor is accessible for the unit tests
    ContainingClass(FileAccessor fileAccessor) {
        this.fileAccessor = fileAccessor;
    }

    // this constructor is used by normal client code
    public ContainingClass() {
        this(new FileAccessor());
    }

    public File getInventoryFileFromProperties(){
        String filePath = fileAccessor.getProperty(ConfigProperties.MY_INVENTORY_FILE);
        return fileAccessor.createFile(filePath);
    }
}