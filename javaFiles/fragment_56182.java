import java.util.ArrayList;
import java.util.List;

public class Partition
{
    public static List<Bag<Integer>> partitions(int n)
    {
        return new Partition(n).partitions;
    }

    private List<Bag<Integer>> partitions;
    private Bag<Integer> current;

    private Partition(int n)
    {
        partitions = new ArrayList<>();
        current = new Bag<Integer>();
        build(n, n);
    }

    private void build(int n, int max)
    {
        if (n == 0)
        {
            partitions.add(0, new Bag<Integer>(current));
        }

        for (int i = Math.min(max, n); i >= 1; i--)
        {
            current.add(i);
            build(n - i, i);
            current.remove(i);
        }
    }

    public static void main(String[] args)
    {
        for (Bag<Integer> b : partitions(5))
        {
            System.out.println(b);
        }
    }
}