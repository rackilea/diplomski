@Name("uploader")
@Scope(ScopeType.SESSION)
public class Uploader {
    byte[] file;

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
        System.out.println("uploaded");
    }

    public void filehash() {
        System.out.println(this.file.hashCode()); // here goes the NPE
    }
}