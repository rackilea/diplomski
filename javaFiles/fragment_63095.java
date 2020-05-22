public class MyFileManager {
    ...
    @XStreamImplicit(itemFieldName = "Group")
    private List<MyGroup> groups = new ArrayList<>();
}

public class MyGroup {
    @XStreamAlias("HeaderName")
    private String headerName;
    @XStreamAlias("Type")
    private String type;

    @XStreamImplicit(itemFieldName = "Piece")
    private List<MyPiece> pieces = new ArrayList<>();

    ...
}

public class MyPiece {
    @XStreamAlias("FileName")
    private String fileName;
    @XStreamAlias("HeadLine")
    private String headLine;

    ...
}