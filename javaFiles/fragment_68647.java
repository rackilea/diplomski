import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindStrings
{
    // Just a simple model class for regions
    static class Pair
    {
        int s = 0;
        int e = 0;

        public Pair (int s, int e)
        {
            this.s = s;
            this.e = e;
        }

        public String toString ()
        {
            return "[" + s + ", " + e + "]";
        }
    }

    public static void main(String[] args)
    {
        String search = "other";

        String str = "this is \"my\" example other string. And \"my other\" this is my str in no quotes.";

        Pattern p = Pattern.compile("\"([^\"]*)\"");
        Matcher m = p.matcher(str);

        List<Pair> deadZones = new ArrayList<Pair>();
        while (m.find())
        {
            int s = m.start();
            int e = m.end();
            deadZones.add(new Pair(s, e - 1));
        }

        List<Pair> hitZones = new ArrayList<Pair>();
        p = Pattern.compile(search);
        m = p.matcher(str);
        while (m.find())
        {
            int s = m.start();
            int e = m.end();
            hitZones.add(new Pair(s, e - 1));
        }

        System.out.println(deadZones);
        System.out.println(hitZones);
    }
}