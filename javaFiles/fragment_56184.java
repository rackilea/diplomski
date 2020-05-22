import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice
{
    public static List<List<Bag<Integer>>> picks(Integer[] diceArr, int k)
    {
        return new Dice(diceArr, k).output;
    }

    private List<List<Bag<Integer>>> output;
    private List<Bag<Integer>> current; 
    private List<Bag<Integer>> partitions;
    private Bag<Integer> dice;

    private Dice(Integer[] diceArr, int k)
    {
        output = new ArrayList<>();
        current = new ArrayList<>();

        partitions = Partition.partitions(5);
        dice = new Bag<>(Arrays.asList(diceArr));

        build(0);
    }

    private void build(int pos)
    {
        for (int i=pos; i<partitions.size(); i++)
        {
            Bag<Integer> partition = partitions.get(i);

            if(dice.contains(partition))
            {
                dice.remove(partition);
                current.add(partition);
                build(i);
                current.remove(partition);              
                dice.add(partition);
            }           
        }

        // Only add the current list of partitions if we haven't already seen it
        if(!current.isEmpty())
        {
            boolean seen = false;
            for(List<Bag<Integer>> prev : output)
            {
                if(prev.containsAll(current)) 
                {
                    seen = true;
                    break;
                }
            }
            if (!seen) output.add(new ArrayList<>(current));
        }
    }

    public static void main(String[] args)
    {
        int count = 5;
        Integer[] dice = {1, 1, 1, 2, 4, 4};
        List<List<Bag<Integer>>> picks = picks(dice, count);
        for(List<Bag<Integer>> pick : picks)
        {
            System.out.println(pick);
        }
    }
}