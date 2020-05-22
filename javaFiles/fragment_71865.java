public enum FileType {
    MAIN("MAIN.TXT"),
    ATTACHMENT("ATTACHMENT.TXT"),
    OTHER("OTHER.HTM");

    // Name in all-caps to make it look like the constant it is
    public final String FILENAME;

    private FileType(String fileName) {
       this.FILENAME = fileName;
    }
}