class LinkStack
{

    private LinkedList theList;
    private String name;

    public LinkStack(String name)             // constructor
    {
        theList = new LinkedList();
        this.name =  name;
    }
    public void push(long j)     // put item on top of stack
    {
        theList.addFirst(j);
    }
    public long pop()            // take item from top of stack
    {
        return (Long)theList.removeFirst();
    }
    public boolean isEmpty()       // true if stack is empty
    {
        return ( theList.isEmpty() );
    }
    public void displayStack(String name)
    {
        System.out.print(name + ": (top-->bottom): ");
        System.out.println(theList);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}