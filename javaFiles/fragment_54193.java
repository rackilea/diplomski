public class Blocks implements Serializable
{
    public boolean canWalk, onTop, itemTaken;
    public ImageIcon img = null, imgBack = null;
    public final ImageIcon (a ton of different images)
    public String name, item, message, title;
    public char initMap, initEx, initIt;
    public int x, y, height, width;

    public Blocks()
    {
        canWalk = true;
        onTop = false;
        itemTaken = false;
        img = null;
        // img = new ImageIcon(someImageInstance)
        name = null;
        item = null;
        message = null;
        x = 0;
        y = 0;
        height = 0;
        width = 0;
    }
}