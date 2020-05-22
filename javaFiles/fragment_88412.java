public class Stack
{
    private ArrayList<Object> stack = new ArrayList<Object>();
    private int stack_pointer;

    public void push(Object obj)
    {
       stack.add(stack_pointer++, obj);
    }

    // Other methods

    public void clear()
    {
       stack.clear();
       stack_pointer = 0;
    }
}