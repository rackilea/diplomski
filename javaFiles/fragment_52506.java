import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class VariableNameTest
{
    private static final Map<String,Integer> map;
    static
    {
        Map<String, Integer> m = new LinkedHashMap<String, Integer>();        
        m.put("DRAGON",5);
        m.put("SNAKE",6);
        map = Collections.unmodifiableMap(m);
    }

    public static void main(String[] args)
    {
        System.out.println(getValue("DRAGON"));
        System.out.println(getValue("SNAKE"));
        System.out.println(getValue("Boo!"));
    }

    public static int getValue(String name)
    {
        Integer i = map.get(name);
        if (i == null)
        {
            // Do some error handling here!
        }
        return i;
    }
}