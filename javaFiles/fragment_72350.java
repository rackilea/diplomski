public class AvlTree implements Iterable<Integer>
{

    ...
    class AvlIterator implements Iterator<Integer>
    {
        ... here you have access to the properties of the enclosing AvlTree instance ...
    }
    ...

    public Iterator<Integer> iterator()
    {
        return new AvlIterator ();
    }
    ...

}