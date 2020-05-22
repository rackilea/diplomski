class Node
{
   Node left, right;
   Person value;

   public Node(Person val)  {
     value = val;
   }
}

public class BinaryTree {

   Node head;    

   public BinaryTree() {
      head = null;
   }

   public void insert(Person data) {
       Node tmp = new Node(data);
       if (head == null) head = tmp;
       else
          // do comparisons with head to decide where to add the new node
         head->left = new Node(data);
         // or head->right = new Node(data);
   }

   public void traverse() {

     // could be similar to your printInOrder method
   }

}