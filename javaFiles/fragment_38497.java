@Root
public class Page {
    @Attribute
    String src;
    @Attribute
    String id;
    @Attribute
    String thumbnail;
    @ElementList (required=false)
    public ArrayList<Area> areas;
}