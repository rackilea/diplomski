@Root
public class data {
    @Element
    private String element;
    @ElementList
    private List<List1> data;
}


@Root (inline=true)
class List1 {
    @Element
    private String element1;
    @Element
    private String element2;
    @ElementList (required=false)
    private List<List2> list1;
}

@Root (inline=true)
class List2 {
    @Attribute
    private String attribute;
}