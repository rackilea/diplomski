public class PartialStringList extends ArrayList<String>
{
 public boolean contains(Object o)
 {
    if(!(o instanceof String))
    {
        return false;
    }
    String s = (String)o;
    Iterator<String> iter = iterator();
    while(iter.hasNext())
    {
        String iStr = iter.next();
        if (iStr.contain(s))
        {
            return true;
        }
    }
    return false;
  }
}