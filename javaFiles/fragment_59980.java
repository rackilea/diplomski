@Root
public abstract class MediaEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Element
    public String Title;
    @Element
    public String Description;
    @Element
    public String Url;
    @Element
    public String LocalPath;

    public MediaEntry(@Element(name = "Title") String title,
            @Element(name = "Description") String description,
            @Element(name = "Url") String url,
            @Element(name = "LocalPath") String localPath) {
        Title = title;
        Description = description;
        Url = url;
        LocalPath = localPath;
    }
}