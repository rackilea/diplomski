interface SomethingCollection <T>
{
   public void add(T something);
   public T removeMaxValue();
}

class List implements SomethingCollection<Node> {
    ...
}