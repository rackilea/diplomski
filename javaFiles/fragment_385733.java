public class Node<T> {
   T value;
   Node nextNode;
   public Node(T value, Node nextNode) {
       this.value = value;
       this.nextNode = nextNode;
   }
}