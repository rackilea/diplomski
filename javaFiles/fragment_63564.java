class Node<T> {

   ...

   @Override
   public String toString() {
      return value + (( next != null ) ? ( "--->" + next.toString()) : "" );
   }

   private Node<T> reverse( Function<Node<T>, Node<T>> factory, Node<T> n ) {
      final Node<T> node = factory.apply( this );
      node.setNext( n );
      if( hasNext()) {
         return getNext().reverse( factory, node );
      }
      return node;
   }

   public Node<T> reverse( Function<Node<T>, Node<T>> factory ) {
      return reverse( factory, null );
   }
}

public class ReverseList {

   public static void main(String[] args) {
      final Node<Integer> n1 = new Node<>(  2 );
      final Node<Integer> n2 = new Node<>(  4 );
      final Node<Integer> n3 = new Node<>(  6 );
      final Node<Integer> n4 = new Node<>(  8 );
      final Node<Integer> n5 = new Node<>( 10 );
      n4.setNext(n5);
      n3.setNext(n4);
      n2.setNext(n3);
      n1.setNext(n2);
      System.err.println( n1 );
      final Node<Integer> r = n1.reverse( n -> new Node<>( n.getValue()));
      System.err.println( r );
   }
}