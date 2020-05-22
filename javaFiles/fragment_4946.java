public class InterfaceClass implements IInterface{
    private String filepath;

    public InterfaceClass(String filepath) {
        this.filepath = filepath;
    }

    public String getContent() throws DumbException {
        // use filepath to get the file's content
    }
}