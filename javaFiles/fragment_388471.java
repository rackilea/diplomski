@Root(strict = false)
public class Foo /* A */
{
    @Element(name = "id")
    public int id; /* B */
    @Element(name="bar")
    public String info;
    @ElementList(entry="c", inline=true, required=false, empty = false)
    public List<EntryWrapper> values; // Replacing the String with the EntryWrapper

    // ...
}