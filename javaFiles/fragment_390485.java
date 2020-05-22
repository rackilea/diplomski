import java.util.*;


public class Sequence<T>
{
    private List<T> sequence=new ArrayList<T>();

    public int length()
    {
        return sequence.size();
    }

    public T get(int index)
    {
        return sequence.get(index);
    }

    public void set(int index, T value)
    {
        sequence.set(index,value);
    }

    public List<T> subList(int startIndex, int size)
    {
        return sequence.subList(startIndex, startIndex+size);
    }

    public <T> T[] subArray(int startIndex, int size)
    {
        return (T[])subList(startIndex, size).toArray();
    }
}