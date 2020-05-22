import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class KeyValueListTest
{
    public static void main(String[] args)
    {
        Map<Integer, IntArrayNode> map = new TreeMap<Integer, IntArrayNode>();
        map.put(0, new IntArrayNode(new int[]{1,2,4,8,16}));
        map.put(3, new IntArrayNode(new int[]{4,5,7,11,19}));
        map.put(7, new IntArrayNode(new int[]{8,9,11,15,23}));

        System.out.println("Before update:");
        for (Map.Entry<Integer, IntArrayNode> e : map.entrySet()) 
        {
            System.out.println(e);
        }

        update(map);

        System.out.println("After update:");
        for (Map.Entry<Integer, IntArrayNode> e : map.entrySet()) 
        {
            System.out.println(e);
        }
    }

    private static void update(IntArrayNode node, int minValue)
    {
        for (int i=0; i<node.getNumElements(); i++)
        {
            node.setElement(i, Math.max(minValue, node.getElement(i)));
        }
    }

    public static void update(Map<Integer, IntArrayNode> map) 
    {
        Map.Entry<Integer, IntArrayNode> previous = null;
        for (Map.Entry<Integer, IntArrayNode> e : map.entrySet()) 
        {
            if (previous != null)
            {
                update(previous.getValue(), e.getKey());
            }
            previous = e;
        }
    }
}


class IntArrayNode
{
    private final int elements[];

    IntArrayNode(int elements[])
    {
        this.elements = elements.clone();
    }

    int getNumElements()
    {
        return elements.length;
    }

    int getElement(int index)
    {
        return elements[index];
    }
    void setElement(int index, int value)
    {
        elements[index] = value;
    }
    @Override
    public String toString()
    {
        return Arrays.toString(elements);
    }
}