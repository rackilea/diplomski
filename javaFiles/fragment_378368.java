@org.simpleframework.xml.Root(strict = false, name = "root")
class Root
{
    @Element
    private String title;

    @Element
    private String desc;

    @ElementList(required = true, name = "mixture")
    ArrayList<GenericNode> genericNodes;

    // ...
}