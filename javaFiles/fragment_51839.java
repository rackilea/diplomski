public class test {

   public static void main(String[] args){
      node rootNode = new node(5);
      rootNode.r = new node(4);
      rootNode.l = new node(3);
      rootNode.r.r = new node(2);
      rootNode.r.l = new node(1);
      rootNode.l.r = new node(6);
      rootNode.l.l = new node(7);

      reverseInOrder(rootNode, 0);
   }

   public static void reverseInOrder(node h, int indent) { 
      if (h != null) {
         indent++;
         reverseInOrder(h.r, indent);

         for (int i = 0; i < indent; i++) {
            System.out.print("  ");
         }
         System.out.println(h.value);

         reverseInOrder(h.l, indent);
      }
   }
}