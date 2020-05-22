@XStreamAlias("list")
public class MyList {
    @XStreamAlias("name")
    String name;
    @XStreamImplicit(itemFieldName="file")
    List<MyFile> files;
}

@XStreamAlias("file")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"path"})
public static class MyFile {
    @XStreamAlias("type")
    @XStreamAsAttribute
    String type;

    String path;
}