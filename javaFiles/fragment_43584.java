public class Queue extends MyList {
    private int index;
    private int firstIndex;

    Queue(int a, int b)
    {
        super(a, b);
    }
    public void enqueue(Object o)
    {
        add(o);
        index++;
    }
    public Object deueue() throws Exception {
        if(firstIndex == index || isEmpty()) {
            firstIndex =0; index =0;
            throw new Exception("");
        }
        else
            return list.remove(++firstIndex);
    }
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}