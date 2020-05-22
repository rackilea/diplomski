public class Main {
public static void main(String[] args) {
LinkedList theList = new LinkedList();
LinkedListIterator theItr;

theItr = theList.zeroth();
printList(theList);

for (int i = 0; i < 10; i++) {
  theList.insert(new Integer(i), theItr);
  printList(theList);
  theItr.advance();
}
System.out.println("Size was: " + listSize(theList));

}

public static int listSize(LinkedList theList) {
LinkedListIterator itr;
int size = 0;
for (itr = theList.first(); itr.isValid(); itr.advance())
  size++;
return size;
  }

 public static void printList(LinkedList theList) {
if (theList.isEmpty())
   System.out.print("Empty list");
 else {
   LinkedListIterator itr = theList.first();
   for (; itr.isValid(); itr.advance())
    System.out.print(itr.retrieve() + " ");
  }
  System.out.println();
}
}

class LinkedList {
 public LinkedList() {
header = new ListNode(null);
 }

public boolean isEmpty() {
return header.next == null;
}

public void makeEmpty() {
header.next = null;
}

 public LinkedListIterator zeroth() {
  return new LinkedListIterator(header);
 }

 public LinkedListIterator first() {
 return new LinkedListIterator(header.next);
 }

  public void insert(Object x, LinkedListIterator p) {
  if (p != null && p.current != null)
  p.current.next = new ListNode(x, p.current.next);
}

 public LinkedListIterator find(Object x) {
ListNode itr = header.next;

while (itr != null && !itr.element.equals(x))
  itr = itr.next;

return new LinkedListIterator(itr);
 }

  public LinkedListIterator findPrevious(Object x) {
  ListNode itr = header;

 while (itr.next != null && !itr.next.element.equals(x))
  itr = itr.next;

return new LinkedListIterator(itr);
  }

public void remove(Object x) {
LinkedListIterator p = findPrevious(x);

if (p.current.next != null)
  p.current.next = p.current.next.next; // Bypass deleted node
}

 private ListNode header;

}

class LinkedListIterator {
LinkedListIterator(ListNode theNode) {
current = theNode;
  }

  public boolean isValid() {
 return current != null;
  }

  public Object retrieve() {
return isValid() ? current.element : null;
  }

public void advance() {
  if (isValid())
  current = current.next;
  }

  ListNode current;
}

class ListNode {
  public ListNode(Object theElement) {
this(theElement, null);
  }

  public ListNode(Object theElement, ListNode n) {
   element = theElement;
    next = n;
  }

  public Object element;

  public ListNode next;
}