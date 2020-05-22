import java.util.Arrays;

public class OrderingAddTest
{
    static int theSize = 0;
    static String[] items = new String[theSize];
    public static void main(String[] args)
    {
        add("a");
        add("e");
        add("d");
        add("b");
        add("c");

        System.out.println(Arrays.toString(items)+"\n; items.length="+items.length);
    }

    private static boolean add(String x)
    {
        theSize++;
        String[] newItems = new String[theSize];
        for(int i = 0; i < theSize - 1; i++)
            if(items[i].compareTo(x) > 0)
            {
                newItems[i] = x;
                newItems[i + 1] = items[i];
                for(int j = i + 2; j < theSize; j++)
                    newItems[j] = items[j - 1];
                items = newItems;
                return true;
            }
            else
                newItems[i] = items[i];
        newItems[theSize - 1] = x;
        items = newItems;
        return true;
    }
}