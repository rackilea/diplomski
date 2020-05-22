@org.simpleframework.xml.Root(strict = false)
@Convert(GenericNodeConverter.class)
public class GenericNode
{
    private String name;
    private int id;
    private String type;


    // ...
}