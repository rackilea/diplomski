// a class with a public static method that encapsulates a static list
public class Bar
{
    static List<Foo> innerlist = new ArrayList<Foo>();

    public static void add( Foo o )
    {
        innerList.add(o);
    }
}