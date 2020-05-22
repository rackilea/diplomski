public class CollectionsDemo {
public static void main(String args[]) {  
  // create linked list object         
  LinkedList list = new LinkedList();  

  // populate the list 
  list.add(-28);  
  list.add(20);  
  list.add(-12);  
  list.add(8);  

  // create comparator for reverse order
  Comparator cmp = Collections.reverseOrder();  

  // sort the list
  Collections.sort(list, cmp);  

  System.out.println("List sorted in ReverseOrder: ");      
  for(int i : list){
     System.out.println(i+ " ");
  } 
  }
  }