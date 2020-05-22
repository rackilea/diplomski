import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tuple<R, S, T>
{

private R name;
private S data;
private T index;

public Tuple(R r, S s, T t)
{
    this.name = r;
    this.data = s;
    this.index = t;
}

public static void main(String[] args)
{
    List<Tuple<String, int[], Integer>> tuples = new ArrayList<Tuple<String, int[], Integer>>();
    // insert elements in no special order
    tuples.add(new Tuple<String, int[], Integer>("Joe", new int[] { 1 }, 2));
    tuples.add(new Tuple<String, int[], Integer>("May", new int[] { 1 }, 1));
    tuples.add(new Tuple<String, int[], Integer>("Phil", new int[] { 1 }, 3));

    Comparator<Tuple<String, int[], Integer>> comparator = new Comparator<Tuple<String, int[], Integer>>()
    {

        public int compare(Tuple<String, int[], Integer> tupleA,
                Tuple<String, int[], Integer> tupleB)
        {
            return tupleA.getIndex().compareTo(tupleB.getIndex());
        }

    };

    Collections.sort(tuples, comparator);

    for (Tuple<String, int[], Integer> tuple : tuples)
    {
        System.out.println(tuple.getName() + " -> " + tuple.getIndex());
    }

}

public R getName()
{
    return name;
}

public void setName(R name)
{
    this.name = name;
}

public S getData()
{
    return data;
}

public void setData(S data)
{
    this.data = data;
}

public T getIndex()
{
    return index;
}

public void setIndex(T index)
{
    this.index = index;
}

}