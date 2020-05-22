public class LinkedList 
{
private Node currentNode;
private Node firstNode;
private int nodeCount;


public static void main(String[] args)
 {
  String     data;
  Object     hold;
  LinkedList list;

  data = "abcdefghijklmnopqrstuvwxyz";
  hold = null;
  list = new LinkedList();

  for(int i=0; i< data.length(); i++) { list.insert(new String(new char[] { data.charAt(i) }));  }
  System.out.println("[1] "+list);

  for(int i=0; i< data.length(); i++) { list.deleteCurrentNode(); }
  System.out.println("[2] "+list);

  for(int i=0; i< data.length(); i++)
  {
   list.insertBeforeCurrentNode(new String(new char[] { data.charAt(i) }));
   if(i%2 == 0) { list.first(); } else { list.last(); }
  }

  System.out.println("[3] "+list);

  for(int i=0; i< data.length(); i++) { list.last(); list.deleteCurrentNode(); }
  System.out.println("[4] "+list);


  for(int i=0; i< data.length(); i++) { list.insert(new String(new char[] { data.charAt(i) })); list.last(); }
  System.out.println("[5] "+list);

  while(!list.isEmpty()) { list.deleteFirstNode(); }
  System.out.println("[6] "+list);

  for(int i=0; i< data.length(); i++) { list.insert(new String(new char[] { data.charAt(i) })); list.last(); }
  System.out.println("[7] "+list);

  while(!list.isEmpty()) { list.deleteFirstNode(false); }
  System.out.println("[8] "+list);

  for(int i=0; i< data.length(); i++) { list.insertBeforeCurrentNode(new String(new char[] { data.charAt(i) })); list.first(); }
  System.out.println("[9] "+list);

  list.first();
  list.next();
  list.deleteFirstNode(true);
  list.deleteCurrentNode();
  for(int i=0; i< 5; i++)  { hold = list.getData();  list.next(); }
  for(int i=0; i< 10; i++) { list.next();   }
  list.insertAfterCurrentNode(hold);
  list.first();
  list.next();
  hold = list.getData();
  list.deleteCurrentNode();
  for(int i=0; i<9; i++)  {list.deleteCurrentNode();  list.last(); }
  list.insert(hold);
  list.first();
  list.next();
  list.next();
  list.next();
  list.deleteFirstNode(false);
  hold = list.getData();
  list.deleteCurrentNode();
  list.last();
  list.insertAfterCurrentNode(hold);
  list.deleteFirstNode();
  list.deleteFirstNode();
  hold = list.getData();
  list.deleteFirstNode();
  list.last();
  list.insertBeforeCurrentNode(hold);
  list.first();
  for(int i=0; i<6; i++) { list.next(); }
  hold = list.getData();
  list.deleteCurrentNode();
  list.last();
  list.insertBeforeCurrentNode(hold);
  list.first();
  list.deleteCurrentNode();
  list.deleteCurrentNode();
  hold = list.getData();
  list.deleteCurrentNode();
  for (int i=0; i< 7; i++) { list.next(); }
  list.insertBeforeCurrentNode(hold);
  for (int i=0; i< 4; i++) { list.first(); list.deleteCurrentNode(); }
  System.out.println("\n\n"+list);


 }

public LinkedList()
{
    setListPtr(null);
    setCurrent(null);
    nodeCount = 0;
}

public boolean atEnd()
{
    if (getCurrent() != null)
       {
         return getCurrent().getNext() == null;
       }
       return true;

}

public boolean isEmpty()
{
    return getListPtr() == null;
}

public void first()
{
    setCurrent(getListPtr());
}

public void next()
{
    checkCurrent();
    if (atEnd()) {throw new InvalidPositionInListException("You are at the end of the list. There is no next node. next().");}
    setCurrent(this.currentNode.getNext());
}

public void last()
{
    if (isEmpty()) {throw new ListEmptyException("The list is currently empty! last()");}

    while (!atEnd())
    {
        setCurrent(getCurrent().getNext());
    }

}

public Object getData()
{
    return getCurrent().getData();
}

public void insertBeforeCurrentNode(Object bcNode) //beforeCurrentNode
{
    Node current;
    Node hold;
    boolean done;
    hold = allocateNode();
    hold.setData(bcNode);
    current = getListPtr();
    done = false;
    if (isEmpty())
    {
        setListPtr(hold);
        setCurrent(hold);       
    }

    else if (getCurrent() == getListPtr())
    {
    //  System.out.println("hi" + hold);
        hold.setNext(getCurrent());
        setListPtr(hold);
    }

    else if (!isEmpty() && getCurrent() != getListPtr())
    {
        while (!done && current.getNext() != null)
        {
            //System.out.println("in else if " + hold);
            if (current.getNext() == getCurrent())
            {
                //previous.setNext(hold);
                //System.out.println("hi"+ "yo" + " " + getListPtr());
                hold.setNext(current.getNext());
                current.setNext(hold);
                done = true; 
            }

            //previous = current;
            current = current.getNext();
        }

    }
    //System.out.println("current " + getCurrent());
    //System.out.println("pointer " + getListPtr());

}

public void insertAfterCurrentNode(Object acNode) //afterCurrentNode
{
    Node hold;
    hold = allocateNode();
    hold.setData(acNode);
    if (isEmpty())
    {
        setListPtr(hold);
        setCurrent(hold);
        //System.out.println(hold + " hi");
    }

    else 
    {
        //System.out.println(hold + " hia");
        hold.setNext(getCurrent().getNext());
        getCurrent().setNext(hold);
    }
}

public void insert(Object iNode)
{
    insertAfterCurrentNode(iNode);
}

public Object deleteCurrentNode()
{
    //System.out.println("in delete current");
    Object nData;
    Node previous;

    if (isEmpty()) {throw new ListEmptyException("The list is currently empty! last()");} //if list is empty throw exception

    checkCurrent(); //check if currentNode is null, method throws exception if it is.

    nData = getCurrent().getData();

    if (getCurrent() == getListPtr())
    {
        setListPtr(getCurrent().getNext());
        setCurrent(getCurrent().getNext());
        nodeCount = nodeCount -1;
    }

    else 
    {
        previous = getListPtr();
        //System.out.println(getCurrent());
        //System.out.println(previous + "ptrb ");
        while (previous.getNext() != getCurrent())
        {
            previous = previous.getNext();
            //System.out.println("test"+ previous);
        }

        //System.out.println(previous.getNext() == getCurrent());

        if (previous.getNext() == getCurrent())
        {
            //System.out.println("say hi");
            previous.setNext(getCurrent().getNext());
            deAllocateNode(getCurrent());
            setCurrent(previous);
            nodeCount = nodeCount - 1;
        }

        previous.setNext(getCurrent().getNext());

    }

    return nData;
}

public Object deleteFirstNode(boolean toDelete)
{
    if (toDelete)
    {
        setCurrent(getListPtr().getNext());
    }
    deAllocateNode(getListPtr());
    setListPtr(getListPtr().getNext());

    nodeCount = nodeCount - 1;
    return getListPtr();
}

public Object deleteFirstNode()
{
    Object deleteFirst;
    deleteFirst = deleteFirstNode(true);
    //System.out.println("called");
    return deleteFirst;
}

public int size()
{
    return this.nodeCount;
}

public String toString()
{
    String nodeString;
    Node sNode;
    sNode = getListPtr();
    //System.out.println(nodeCount);
    nodeString = ("List contains " + nodeCount + " nodes");
    while (sNode != null)
    {
        nodeString = nodeString + " " +sNode.getData();
        sNode = sNode.getNext();
    }   
    return nodeString;
}

private Node allocateNode()
{
    Node newNode;
    newNode = new Node();
    nodeCount = nodeCount + 1;
    return newNode;
}

private void deAllocateNode(Node dNode)
{
    dNode.setData(null);
}

private Node getListPtr()
{
    return this.firstNode;
}

private void setListPtr(Node pNode)
{
     this.firstNode = pNode;
}

private Node getCurrent()
{
    return this.currentNode;
}

private void setCurrent(Node cNode)
{
    this.currentNode = cNode;
}

private void checkCurrent()
{
    if (getCurrent() == null) {throw new InvalidPositionInListException("Current node is null and is set to an invalid position within the list! checkCurrent()");}
}

/**NODE CLASS ----------------------------------------------*/

    private class Node 
    {
        private Node next; //serves as a reference to the next node 
        private Object data;

        public Node()
        {
            this.next = null;
            this.data = null;
        }


        public Object getData()
        {
            return this.data;
        }

        public void setData(Object obj)
        {
            this.data = obj;
        }

        public Node getNext()
        {
            return this.next;
        }

        public void setNext(Node nextNode)
        {
            this.next = nextNode;
        }

        public String toString()
        {
            String nodeString;
            Node sNode;
            sNode = getListPtr();
            //System.out.println(nodeCount);
            nodeString = ("List contains " + nodeCount + " nodes");
            while (sNode != null)
            {
                nodeString = nodeString + " " +sNode.getData();
                sNode = sNode.getNext();
            }   
            return nodeString;
        }
    }


  }