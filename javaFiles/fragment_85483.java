package quicktest;

/**
 *
 * @author Brenden Towey
 */
public class TreePrint
{

   public static void main( String[] args )
   {
      Node root = new Node();
      fill( root );
      prettyPrintKeys( root );
   }

   public static String prettyPrintKeys( Node root )
   {
//      String output = "";
//      int indent = 0;
      StringBuilder indent = new StringBuilder();
      StringBuilder output = new StringBuilder();

      prettyPrint( root, indent, output );
      System.out.print( output );
      return output.toString();
   }

   private static void prettyPrint( quicktest.TreePrint.Node x,
           StringBuilder indent, StringBuilder output )
   {
//      for( int i = 0; i < indent; i++ )
//         output = output + " |";
      output.append( indent );
//      if( x == null )
//         return output = output + "-null\n";
      output.append( "-" );
      output.append( x );
      output.append( "\n" );
      if( x == null ) return;
//      indent++;
//      output = output + "-" + x.key + "\n" + prettyPrint( x.left, indent );
      indent.append( " |" );
      prettyPrint( x.left, indent, output );
//      indent--;
//      output = output + prettyPrint( x.right, indent );
      indent.delete( indent.length()-2, indent.length() );
      indent.append( "  " );  // <<-- second indent style
      prettyPrint( x.right, indent, output );

      // needed a second indent-- here
      indent.delete( indent.length()-2, indent.length() );
   }

   private static class Node
   {

      Comparable key;
      Node left;
      Node right;

      @Override
      public String toString()
      {
         return "Node{" + "key=" + key + '}';
      }


   }

   private static void fill( Node root )
   {
      insert( root, 7 );
      insert( root, 8 );
      insert( root, 3 );
      insert( root, 1 );
      insert( root, 2 );
      insert( root, 6 );
      insert( root, 4 );
      insert( root, 5 );
   }

   private static void insert( quicktest.TreePrint.Node node, Comparable newKey )
   {
      if( node.key == null ) {
         node.key = newKey;
         return;
      }
      if( node.key.compareTo( newKey ) > 0 ) {
         if( node.left == null ) node.left = new Node();
         insert( node.left, newKey );
         return;
      }
      if( node.right == null ) node.right = new Node();
      insert( node.right, newKey );
   }
}