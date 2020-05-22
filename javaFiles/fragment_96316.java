public class LinkedListArray{

    private int DEFAULT_CAPACITY=10;
    private int SIZE=0;

    private LinkedList1[] arr;

    public LinkedListArray() {

        arr=new LinkedList1[DEFAULT_CAPACITY];

    }   

    public LinkedListArray(int capacity) {

        arr=new LinkedList1[capacity];

    }

    public LinkedList1 insert(int index, LinkedListArray.LinkedList1.Node Node) {

        if(arr[index]==null)    arr[index]=new LinkedList1();

        arr[index].sortedInsert(Node);;
        SIZE++;
        return arr[index];
    }

    public LinkedList1 get(int index) {

        return arr[index];
    }

    public int size() {

        return SIZE;
    }


//Java Program to insert in a sorted list
class LinkedList1
{

public LinkedList1() {} 
Node head;  // head of list

/* Linked list Node*/
class Node
{
 int s;
 int a;
 Node next;
 Node(int starting_time,int arrival_time) {s = starting_time; a=arrival_time;next = null; }
}

/* function to insert a new_node in a list. */
void sortedInsert(Node new_node)
{
  Node current;

  /* Special case for head node */
  if (head == null || head.a >= new_node.a)
  {
     new_node.next = head;
     head = new_node;
  }
  else {

     /* Locate the node before point of insertion. */
     current = head;

     while (current.next != null &&
            current.next.a < new_node.a)
           current = current.next;

     new_node.next = current.next;
     current.next = new_node;
  }
}

           /*Utility functions*/

/* Function to create a node */
Node newNode(int s,int a)
{
Node x = new Node(s,a);
return x;
}

/* Function to print linked list */
void printList()
{
  Node temp = head;
  while (temp != null)
  {
     System.out.print("["+temp.s+","+temp.a+"] ");
     temp = temp.next;
  }
}

/* Drier function to test above methods */

}


public static void main(String args[])
{
    LinkedListArray arr=new LinkedListArray();


  arr.insert(0,  new LinkedListArray().new LinkedList1().newNode(5, 4));
  arr.insert(0,  new LinkedListArray().new LinkedList1().newNode(10, 4));
  arr.insert(0, new LinkedListArray().new LinkedList1().newNode(4, 34));


  System.out.println("Created Linked List and inserted in array");
  arr.get(0).printList();
}
}